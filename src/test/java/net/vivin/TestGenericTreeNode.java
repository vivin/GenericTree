/*

 Copyright 2010 Vivin Suresh Paliath
 Distributed under the BSD License
*/

package net.vivin;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;

public class TestGenericTreeNode {
    @Test
    public void TestNodeDataIsNullOnNewNodeCreation() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        assertNull(node.getData());
    }

    @Test
    public void TestNodeHasNonNullChildrenListOnNewNodeCreation() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        assertNotNull(node.getChildren());
    }

    @Test
    public void TestNodeHasZeroChildrenOnNewNodeCreation() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        assertEquals(node.getNumberOfChildren(), 0);
    }

    @Test
    public void TestNodeHasChildrenReturnsFalseOnNewNodeCreation() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        assertFalse(node.hasChildren());
    }

    @Test
    public void TestNodeDataIsNonNullWithParameterizedConstructor() {
        GenericTreeNode<String> node = new GenericTreeNode<String>("I haz data");
        assertNotNull(node.getData());
    }

    @Test
    public void TestNodeSetAndGetData() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        String data = "data";
        node.setData(data);
        assertEquals(node.getData(), data);
    }

    @Test
    public void TestNodeSetAndGetChildren() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        GenericTreeNode<String> child = new GenericTreeNode<String>();

        List<GenericTreeNode<String>> children = new ArrayList<GenericTreeNode<String>>();
        children.add(child);

        node.setChildren(children);
        assertEquals(node.getChildren(), children);
    }

    @Test
    public void TestNodeSetAndGetChildrenHasCorrectParent() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        GenericTreeNode<String> child = new GenericTreeNode<String>();

        List<GenericTreeNode<String>> children = new ArrayList<GenericTreeNode<String>>();
        children.add(child);

        node.setChildren(children);
        assertEquals(node.getChildren(), children);

        for(GenericTreeNode<String> childNode : children) {
            assertEquals(node, childNode.getParent());
        }
    }

    @Test
    public void TestNodeRemoveChildren() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        GenericTreeNode<String> child = new GenericTreeNode<String>();

        List<GenericTreeNode<String>> children = new ArrayList<GenericTreeNode<String>>();
        children.add(child);

        node.setChildren(children);
        node.removeChildren();
        assertEquals(node.getChildren().size(), 0);
    }

    @Test
    public void TestNodeAddChildHasCorrectParent() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        GenericTreeNode<String> child = new GenericTreeNode<String>();

        node.addChild(child);
        assertEquals(node, child.getParent());
    }

    @Test
    public void TestNodeAddChildHasOneChild() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        GenericTreeNode<String> child = new GenericTreeNode<String>();

        node.addChild(child);
        assertEquals(node.getNumberOfChildren(), 1);
    }

    @Test
    public void TestNodeAddChildHasChildrenIsTrue() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        GenericTreeNode<String> child = new GenericTreeNode<String>();

        node.addChild(child);
        assertTrue(node.hasChildren());
    }

    @Test
    public void TestNodeAddAndGetChildAt() {
        GenericTreeNode<String> node = new GenericTreeNode<String>("root");
        GenericTreeNode<String> child1 = new GenericTreeNode<String>("child1");
        GenericTreeNode<String> child2 = new GenericTreeNode<String>("child2");

        node.addChild(child1);
        node.addChildAt(1, child2);

        assertEquals(node.getChildAt(1).getData(), child2.getData());
    }

    @Test
    public void TestNodeAddAndRemoveChildAt() {
        GenericTreeNode<String> node = new GenericTreeNode<String>("root");
        GenericTreeNode<String> child1 = new GenericTreeNode<String>("child1");
        GenericTreeNode<String> child2 = new GenericTreeNode<String>("child2");

        node.addChild(child1);
        node.addChildAt(1, child2);

        node.removeChildAt(0);

        assertEquals(node.getNumberOfChildren(), 1);
    }

    @Test(expectedExceptions = java.lang.IndexOutOfBoundsException.class)
    public void TestNodeAddChildAtThrowsException() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        GenericTreeNode<String> child = new GenericTreeNode<String>();

        node.addChildAt(5, child);
    }

    @Test(expectedExceptions = java.lang.IndexOutOfBoundsException.class)
    public void TestNodeRemoveChildAtThrowsException() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        node.removeChildAt(1);
    }

    @Test
    public void TestNodeToString() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        node.setData("data");
        assertEquals(node.toString(), "data");
    }

    @Test
    public void TestNodeToStringVerboseNoChildren() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        node.setData("data");
        assertEquals(node.toStringVerbose(), "data:[]");
    }

    @Test
    public void TestNodeToStringVerboseOneChild() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        node.setData("data");

        GenericTreeNode<String> child = new GenericTreeNode<String>();
        child.setData("child");

        node.addChild(child);
        assertEquals(node.toStringVerbose(), "data:[child]");
    }

    @Test
    public void TestNodeToStringVerboseMoreThanOneChild() {
        GenericTreeNode<String> node = new GenericTreeNode<String>();
        node.setData("data");

        GenericTreeNode<String> child1 = new GenericTreeNode<String>();
        child1.setData("child1");

        GenericTreeNode<String> child2 = new GenericTreeNode<String>();
        child2.setData("child2");

        node.addChild(child1);
        node.addChild(child2);

        assertEquals(node.toStringVerbose(), "data:[child1, child2]");
    }
}
