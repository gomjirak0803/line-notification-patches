package app.linenotifications.patches.settings

import app.morphe.patcher.patch.resourcePatch

/** Custom content only: DecoratedCustomViewStyle retains Android's action/inline-reply area. */
internal val notificationBadgeResourcesPatch = resourcePatch {
    execute {
        val title = """
            <LinearLayout
                android:layout_width="wrap_content" android:layout_height="wrap_content"
                android:orientation="horizontal" android:gravity="center_vertical"
                android:layout_marginBottom="3dp">
                <TextView android:id="@+id/line_notify_room"
                    android:textAppearance="@android:style/TextAppearance.Material.Notification.Title"
                    android:layout_width="wrap_content" android:layout_height="wrap_content"
                    android:layout_weight="1" android:singleLine="true" android:ellipsize="end" />
                <TextView android:id="@+id/line_notify_count"
                    android:textAppearance="@android:style/TextAppearance.Material.Notification.Info"
                    android:layout_width="wrap_content" android:layout_height="wrap_content"
                    android:layout_marginStart="6dp" android:minWidth="20dp" android:minHeight="20dp"
                    android:paddingStart="5dp" android:paddingEnd="5dp"
                    android:paddingTop="1dp" android:paddingBottom="1dp"
                    android:gravity="center" android:singleLine="true" android:textSize="12sp"
                    android:textColor="@color/line_notify_badge_text"
                    android:background="@drawable/line_notify_badge_background" />
            </LinearLayout>
        """.trimIndent()
        fun line(id: String, initiallyHidden: Boolean = false, spaced: Boolean = false) = """
            <TextView android:id="@+id/$id"
                android:textAppearance="@android:style/TextAppearance.Material.Notification.Line2"
                android:layout_width="match_parent" android:layout_height="wrap_content"
                android:layout_marginTop="${if (spaced) "2dp" else "0dp"}"
                android:singleLine="true" android:ellipsize="end"
                android:visibility="${if (initiallyHidden) "gone" else "visible"}" />
        """.trimIndent()
        fun layout(body: String) = """
            <?xml version="1.0" encoding="utf-8"?>
            <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent" android:layout_height="wrap_content"
                android:orientation="vertical">
                $title
                $body
            </LinearLayout>
        """.trimIndent()
        val resources = mapOf(
            "layout/line_notify_compact.xml" to layout(line("line_notify_preview")),
            "layout/line_notify_expanded.xml" to layout(
                (1..5).joinToString("\n") { line("line_notify_message_$it", initiallyHidden = true, spaced = it > 1) }
            ),
            "drawable/line_notify_badge_background.xml" to """
                <?xml version="1.0" encoding="utf-8"?>
                <shape xmlns:android="http://schemas.android.com/apk/res/android" android:shape="rectangle">
                    <solid android:color="@color/line_notify_badge_fill" />
                    <corners android:radius="3dp" />
                </shape>
            """.trimIndent(),
        )
        resources.forEach { (path, xml) ->
            get("res/$path").apply {
                parentFile.mkdirs()
                // Interpolated multi-line snippets can reduce trimIndent's common indent to
                // zero. An XML declaration must still begin at the first character.
                writeText(xml.trimStart())
            }
        }
        // Update the existing typed values documents so Morphe allocates resource IDs.
        for ((qualifier, fill, text) in listOf(
            Triple("values", "#E6E8EB", "#34383D"),
            Triple("values-night", "#41464D", "#F1F3F5"),
        )) {
            document("res/$qualifier/colors.xml").use { doc ->
                val root = doc.getElementsByTagName("resources").item(0)
                for ((name, value) in mapOf("line_notify_badge_fill" to fill, "line_notify_badge_text" to text)) {
                    root.appendChild(doc.createElement("color").apply {
                        setAttribute("name", name)
                        textContent = value
                    })
                }
            }
        }
    }
}
