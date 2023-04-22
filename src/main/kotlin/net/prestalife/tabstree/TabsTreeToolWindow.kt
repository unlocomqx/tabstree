package net.prestalife.tabstree

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.treeStructure.Tree
import javax.swing.JComponent
import javax.swing.JPanel

class TabsTreeToolWindow : ToolWindowFactory, DumbAware {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val toolWindowContent: CalendarToolWindowContent = CalendarToolWindowContent(toolWindow)
        val content = ContentFactory.getInstance().createContent(toolWindowContent.getContentPanel(), "", false)
        toolWindow.contentManager.addContent(content)
    }
}

class CalendarToolWindowContent(toolWindow: ToolWindow) {

    private val contentPanel = JPanel()

    init {
        val tree = Tree()
        contentPanel.add(tree)
    }

    fun getContentPanel(): JComponent {
        return contentPanel
    }

}