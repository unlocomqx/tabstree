package net.prestalife.tabstree

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.treeStructure.Tree
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.tree.DefaultMutableTreeNode


class TabsTreeToolWindow : ToolWindowFactory, DumbAware {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val toolWindowContent = OpenFilesToolWindowContent(toolWindow)
        val content = ContentFactory.getInstance().createContent(toolWindowContent.getContentPanel(), "", false)
        toolWindow.contentManager.addContent(content)
    }
}

class OpenFilesToolWindowContent(toolWindow: ToolWindow) {

    private val contentPanel = JPanel()

    init {
        val root = DefaultMutableTreeNode("Open Files")
        val vegetableNode = DefaultMutableTreeNode("Vegetables")
        val fruitNode = DefaultMutableTreeNode("Fruits")
        //add the child nodes to the root node
        //add the child nodes to the root node
        root.add(vegetableNode)
        root.add(fruitNode)
        val tree = Tree(root)
        contentPanel.add(tree)
    }

    fun getContentPanel(): JComponent {
        return contentPanel
    }

}