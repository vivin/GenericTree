/*
 Copyright 2010 Vivin Suresh Paliath
 Distributed under the BSD License
*/

package net.vivin;

import org.testng.annotations.Test;
import java.util.*;
import static org.testng.Assert.*;

public class TestGenericTree {
    @Test
    public void TestRootIsNullOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();
        assertNull(tree.getRoot());
    }

    @Test
    public void TestNumberOfNodesIsZeroOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();
        assertEquals(tree.getNumberOfNodes(), 0);
    }

    @Test
    public void TestIsEmptyIsTrueOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();
        assertTrue(tree.isEmpty());
    }

    @Test
    void TestExistsIsFalseOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();
        String dataToFind = "";

        assertFalse(tree.exists(dataToFind));
    }

    @Test
    void TestFindReturnsNullOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();
        String dataToFind = "";

        assertNull(tree.find(dataToFind));
    }

    @Test
    void TestPreOrderBuildReturnsNullListOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();

        assertNull(tree.build(GenericTreeTraversalOrderEnum.PRE_ORDER));
    }

    @Test
    void TestPostOrderBuildReturnsNullListOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();

        assertNull(tree.build(GenericTreeTraversalOrderEnum.POST_ORDER));
    }

    @Test
    void TestPreOrderBuildWithDepthReturnsNullMapOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();

        assertNull(tree.buildWithDepth(GenericTreeTraversalOrderEnum.PRE_ORDER));
    }

    @Test
    void TestPostOrderBuildWithDepthReturnsNullMapOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();

        assertNull(tree.buildWithDepth(GenericTreeTraversalOrderEnum.POST_ORDER));
    }

    @Test
    void TestToStringReturnsEmptyStringOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();

        assertEquals(tree.toString(), "");
    }

    @Test
    void TestToStringWithDepthReturnsEmptyStringOnNewTreeCreation() {
        GenericTree<String> tree = new GenericTree<String>();

        assertEquals(tree.toStringWithDepth(), "");
    }

    @Test
    void TestSetRootGetRoot() {
        GenericTree<String> tree = new GenericTree<String>();
        GenericTreeNode<String> root = new GenericTreeNode<String>();
        tree.setRoot(root);

        assertNotNull(tree.getRoot());
    }

    @Test
    void TestNumberOfNodesIsOneWithNonNullRoot() {
        GenericTree<String> tree = new GenericTree<String>();
        GenericTreeNode<String> root = new GenericTreeNode<String>();
        tree.setRoot(root);

        assertEquals(tree.getNumberOfNodes(), 1);
    }

    @Test
    void TestEmptyIsFalseWithNonNullRoot() {
        GenericTree<String> tree = new GenericTree<String>();
        GenericTreeNode<String> root = new GenericTreeNode<String>();
        tree.setRoot(root);

        assertFalse(tree.isEmpty());
    }

    @Test
    void TestPreOrderBuildListSizeIsOneWithNonNullRoot() {
        GenericTree<String> tree = new GenericTree<String>();
        GenericTreeNode<String> root = new GenericTreeNode<String>("root");
        tree.setRoot(root);

        assertEquals(tree.build(GenericTreeTraversalOrderEnum.PRE_ORDER).size(), 1);
    }

    @Test
    void TestPostOrderBuildListSizeIsOneWithNonNullRoot() {
        GenericTree<String> tree = new GenericTree<String>();
        GenericTreeNode<String> root = new GenericTreeNode<String>("root");
        tree.setRoot(root);

        assertEquals(tree.build(GenericTreeTraversalOrderEnum.POST_ORDER).size(), 1);
    }

    @Test
    void TestPreOrderBuildWithDepthSizeIsOneWithNonNullRoot() {
        GenericTree<String> tree = new GenericTree<String>();
        GenericTreeNode<String> root = new GenericTreeNode<String>("root");
        tree.setRoot(root);

        assertEquals(tree.buildWithDepth(GenericTreeTraversalOrderEnum.PRE_ORDER).size(), 1);
    }

    @Test
    void TestPostOrderBuildWithDepthSizeIsOneWithNonNullRoot() {
        GenericTree<String> tree = new GenericTree<String>();
        GenericTreeNode<String> root = new GenericTreeNode<String>("root");
        tree.setRoot(root);

        assertEquals(tree.buildWithDepth(GenericTreeTraversalOrderEnum.POST_ORDER).size(), 1);
    }

    /*
      Tree looks like:
          A
         / \
        B  C
            \
             D

      For the following tests

     */
    @Test
    void TestNumberOfNodes() {
        GenericTree<String> tree = new GenericTree<String>();

        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        assertEquals(tree.getNumberOfNodes(), 4);
    }

    @Test
    void TestExistsReturnsTrue() {
        GenericTree<String> tree = new GenericTree<String>();
        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        String dataToFindD = "D";

        assertTrue(tree.exists(dataToFindD));
    }

    @Test
    void TestFindReturnsNonNull() {
        GenericTree<String> tree = new GenericTree<String>();

        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        String dataToFindD = "D";

        assertNotNull(tree.find(dataToFindD));
    }

    @Test
    void TestExistsReturnsFalse() {
        GenericTree<String> tree = new GenericTree<String>();

        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        String dataToFindE = "E";

        assertFalse(tree.exists(dataToFindE));
    }

    @Test
    void TestFindReturnsNull() {
        GenericTree<String> tree = new GenericTree<String>();

        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        String dataToFindE = "E";

        assertNull(tree.find(dataToFindE));
    }

    // Pre-order traversal will give us A B C D
    @Test
    void TestPreOrderBuild() {
        GenericTree<String> tree = new GenericTree<String>();

        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        List<GenericTreeNode<String>> preOrderList = new ArrayList<GenericTreeNode<String>>();
        preOrderList.add(new GenericTreeNode<String>("A"));
        preOrderList.add(new GenericTreeNode<String>("B"));
        preOrderList.add(new GenericTreeNode<String>("C"));
        preOrderList.add(new GenericTreeNode<String>("D"));

        // Instead of checking equalities on the lists themselves, we can check equality on the toString's
        // they should generate the same toString's

        assertEquals(tree.build(GenericTreeTraversalOrderEnum.PRE_ORDER).toString(), preOrderList.toString());
    }

    //Post-order traversal will give us B D C A
    @Test
    void TestPostOrderBuild() {
        GenericTree<String> tree = new GenericTree<String>();

        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        List<GenericTreeNode<String>> postOrderList = new ArrayList<GenericTreeNode<String>>();
        postOrderList.add(new GenericTreeNode<String>("B"));
        postOrderList.add(new GenericTreeNode<String>("D"));
        postOrderList.add(new GenericTreeNode<String>("C"));
        postOrderList.add(new GenericTreeNode<String>("A"));

        // Instead of checking equalities on the lists themselves, we can check equality on the toString's
        // they should generate the same toString's

        assertEquals(tree.build(GenericTreeTraversalOrderEnum.POST_ORDER).toString(), postOrderList.toString());
     }

    //Pre-order traversal with depth will give us A:0, B:1, C:1, D:2
    @Test
    void TestPreOrderBuildWithDepth() {
        GenericTree<String> tree = new GenericTree<String>();

        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        Map<GenericTreeNode<String>, Integer> preOrderMapWithDepth = new LinkedHashMap<GenericTreeNode<String>, Integer>();
        preOrderMapWithDepth.put(new GenericTreeNode<String>("A"), 0);
        preOrderMapWithDepth.put(new GenericTreeNode<String>("B"), 1);
        preOrderMapWithDepth.put(new GenericTreeNode<String>("C"), 1);
        preOrderMapWithDepth.put(new GenericTreeNode<String>("D"), 2);

        // Instead of checking equalities on the maps themselves, we can check equality on the toString's
        // they should generate the same toString's

        assertEquals(tree.buildWithDepth(GenericTreeTraversalOrderEnum.PRE_ORDER).toString(), preOrderMapWithDepth.toString());
     }

     //Post-order traversal with depth will give us B:1, D:2, C:1, A:0
    @Test
    void TestPostOrderBuildWithDepth() {
        GenericTree<String> tree = new GenericTree<String>();

        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        Map<GenericTreeNode<String>, Integer> postOrderMapWithDepth = new LinkedHashMap<GenericTreeNode<String>, Integer>();
        postOrderMapWithDepth.put(new GenericTreeNode<String>("B"), 1);
        postOrderMapWithDepth.put(new GenericTreeNode<String>("D"), 2);
        postOrderMapWithDepth.put(new GenericTreeNode<String>("C"), 1);
        postOrderMapWithDepth.put(new GenericTreeNode<String>("A"), 0);

        // Instead of checking equalities on the maps themselves, we can check equality on the toString's
        // they should generate the same toString's

        assertEquals(tree.buildWithDepth(GenericTreeTraversalOrderEnum.POST_ORDER).toString(), postOrderMapWithDepth.toString());
    }

    //toString and toStringWithDepth both use pre-order traversal
    @Test
    void TestToString() {
        GenericTree<String> tree = new GenericTree<String>();

        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        List<GenericTreeNode<String>> preOrderList = new ArrayList<GenericTreeNode<String>>();
        preOrderList.add(new GenericTreeNode<String>("A"));
        preOrderList.add(new GenericTreeNode<String>("B"));
        preOrderList.add(new GenericTreeNode<String>("C"));
        preOrderList.add(new GenericTreeNode<String>("D"));

        assertEquals(tree.toString(), preOrderList.toString());
    }

    @Test
    void TestToStringWithDepth() {
        GenericTree<String> tree = new GenericTree<String>();

        GenericTreeNode<String> rootA = new GenericTreeNode<String>("A");
        GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
        GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
        GenericTreeNode<String> childD = new GenericTreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        Map<GenericTreeNode<String>, Integer> preOrderMapWithDepth = new LinkedHashMap<GenericTreeNode<String>, Integer>();
        preOrderMapWithDepth.put(new GenericTreeNode<String>("A"), 0);
        preOrderMapWithDepth.put(new GenericTreeNode<String>("B"), 1);
        preOrderMapWithDepth.put(new GenericTreeNode<String>("C"), 1);
        preOrderMapWithDepth.put(new GenericTreeNode<String>("D"), 2);

        assertEquals(tree.toStringWithDepth(), preOrderMapWithDepth.toString());
    }
}
