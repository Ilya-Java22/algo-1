package main.algo2.graph.simple;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleGraphTest {
    @Test
    public void tes1() {
        SimpleGraph sg = new SimpleGraph(1);
        sg.m_adjacency = new int[][] {
                {0}
        };
        sg.vertex = new Vertex[] {
                new Vertex(1)
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.BreadthFirstSearch(0, 0);
        assertThat(result).isEmpty();
    }

    @Test
    public void tes2() {
        SimpleGraph sg = new SimpleGraph(1);
        sg.m_adjacency = new int[][] {
                {1}
        };
        Vertex v1 = new Vertex(1);
        sg.vertex = new Vertex[] {
                v1
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.BreadthFirstSearch(0, 0);
        List<Vertex> expect = List.of(v1, v1);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test3() {
        SimpleGraph sg = new SimpleGraph(5);
        sg.m_adjacency = new int[][] {
                {0,1,1,0,0},
                {1,0,1,1,0},
                {1,1,0,0,1},
                {0,1,0,0,1},
                {0,0,1,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.BreadthFirstSearch(0, 4);
        List<Vertex> expect = List.of(v1, v3, v5);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test4() {
        SimpleGraph sg = new SimpleGraph(5);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,0},
                {1,0,0,0,0},
                {0,0,0,0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        sg.vertex = new Vertex[] {
                v1, v2, v3
        };
        //System.out.println(sg.DepthFirstSearch(1, 0));
        List<Vertex> result = sg.BreadthFirstSearch(0, 2);
        //List<Vertex> expect = List.of(v1, v3, v5);
        assertThat(result).isEmpty();
    }

    @Test
    public void test5() {
        SimpleGraph sg = new SimpleGraph(5);
        sg.m_adjacency = new int[][] {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,1,0,0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        sg.vertex = new Vertex[] {
                v1, v2, v3
        };
        //System.out.println(sg.DepthFirstSearch(1, 0));
        List<Vertex> result = sg.BreadthFirstSearch(0, 2);
        //List<Vertex> expect = List.of(v1, v3, v5);
        assertThat(result).isEmpty();
    }

    @Test
    public void test6() {
        SimpleGraph sg = new SimpleGraph(4);
        sg.m_adjacency = new int[][] {
                {0,1,1,0,0},
                {1,0,1,0,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.BreadthFirstSearch(0, 3);
        //List<Vertex> expect = List.of(v1, v3, v5);
        assertThat(result).isEmpty();
    }

    @Test
    public void test7() {
        SimpleGraph sg = new SimpleGraph(7);
        sg.m_adjacency = new int[][] {
                {0,1,1,0,0,0,0},
                {1,0,0,1,1,0,0},
                {1,0,0,0,0,1,0},
                {0,1,0,0,1,0,0},
                {0,1,0,1,0,0,1},
                {0,0,1,0,0,0,1},
                {0,0,0,0,1,0,1}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6, v7
        };
        List<Vertex> result = sg.BreadthFirstSearch(0, 6);
        List<Vertex> expect = List.of(v1, v2, v5, v7);
        //или 1367
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test8() {
        SimpleGraph sg = new SimpleGraph(6);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,0,1},
                {1,0,1,0,0,0},
                {0,1,0,1,0,0},
                {0,0,1,0,1,0},
                {0,0,0,1,0,1},
                {1,0,0,0,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6
        };
        List<Vertex> result = sg.BreadthFirstSearch(0, 3);
        List<Vertex> expect = List.of(v1, v2, v3, v4);
        assertThat(result).isEqualTo(expect);
    }

    //тесты на циклы (не работают в этой версии метода)

//    @Test
//    public void test9() {
//        SimpleGraph sg = new SimpleGraph(3);
//        sg.m_adjacency = new int[][] {
//                {0,1,1},
//                {1,0,1},
//                {1,1,0}
//        };
//        Vertex v1 = new Vertex(1);
//        Vertex v2 = new Vertex(2);
//        Vertex v3 = new Vertex(3);
//        sg.vertex = new Vertex[] {
//                v1, v2, v3
//        };
//        List<Vertex> result = sg.BreadthFirstSearch(0, 0);
//        List<Vertex> expect = List.of(v1, v2, v3, v1);
//        assertThat(result).isEqualTo(expect);
//    }

//    @Test
//    public void test10() {
//        SimpleGraph sg = new SimpleGraph(4);
//        sg.m_adjacency = new int[][] {
//                {0,1,1,1},
//                {1,0,0,0},
//                {1,0,0,1},
//                {1,0,1,0}
//        };
//        Vertex v1 = new Vertex(1);
//        Vertex v2 = new Vertex(2);
//        Vertex v3 = new Vertex(3);
//        Vertex v4 = new Vertex(4);
//        sg.vertex = new Vertex[] {
//                v1, v2, v3, v4
//        };
//        List<Vertex> result = sg.BreadthFirstSearch(0, 0);
//        List<Vertex> expect = List.of(v1, v3, v4, v1);
//        assertThat(result).isEqualTo(expect);
//    }
//
//    @Test
//    public void test11() {
//        SimpleGraph sg = new SimpleGraph(6);
//        sg.m_adjacency = new int[][] {
//                {0,1,1,1,0,0},
//                {1,0,0,0,0,0},
//                {1,0,0,1,1,0},
//                {1,0,1,0,0,1},
//                {0,0,1,0,0,1},
//                {0,0,0,1,1,0}
//        };
//        Vertex v1 = new Vertex(1);
//        Vertex v2 = new Vertex(2);
//        Vertex v3 = new Vertex(3);
//        Vertex v4 = new Vertex(4);
//        Vertex v5 = new Vertex(5);
//        Vertex v6 = new Vertex(6);
//        sg.vertex = new Vertex[] {
//                v1, v2, v3, v4, v5, v6
//        };
//        List<Vertex> result = sg.BreadthFirstSearch(0, 0);
//        List<Vertex> expect = List.of(v1, v3, v4, v1);
//        assertThat(result).isEqualTo(expect);
//    }

    //тест Deep c циклами

    @Test
    public void tes1Deep() {
        SimpleGraph sg = new SimpleGraph(1);
        sg.m_adjacency = new int[][] {
                {0}
        };
        sg.vertex = new Vertex[] {
                new Vertex(1)
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.DepthFirstSearch (0, 0);
        assertThat(result).isEmpty();
    }

    @Test
    public void tes2Deep() {
        SimpleGraph sg = new SimpleGraph(1);
        sg.m_adjacency = new int[][] {
                {1}
        };
        Vertex v1 = new Vertex(1);
        sg.vertex = new Vertex[] {
                v1
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.DepthFirstSearch (0, 0);
        List<Vertex> expect = List.of(v1, v1);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test3Deep() {
        SimpleGraph sg = new SimpleGraph(5);
        sg.m_adjacency = new int[][] {
                {0,1,1,0,0},
                {1,0,1,1,0},
                {1,1,0,0,1},
                {0,1,0,0,1},
                {0,0,1,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.DepthFirstSearch (0, 4);
        List<Vertex> expect = List.of(v1, v2, v3, v5);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test4Deep() {
        SimpleGraph sg = new SimpleGraph(3);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,0},
                {1,0,0,0,0},
                {0,0,0,0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        sg.vertex = new Vertex[] {
                v1, v2, v3
        };
        //System.out.println(sg.DepthFirstSearch(1, 0));
        List<Vertex> result = sg.DepthFirstSearch (0, 2);
        //List<Vertex> expect = List.of(v1, v3, v5);
        assertThat(result).isEmpty();
    }

    @Test
    public void test5Deep() {
        SimpleGraph sg = new SimpleGraph(3);
        sg.m_adjacency = new int[][] {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,1,0,0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        sg.vertex = new Vertex[] {
                v1, v2, v3
        };
        //System.out.println(sg.DepthFirstSearch(1, 0));
        List<Vertex> result = sg.DepthFirstSearch (0, 2);
        //List<Vertex> expect = List.of(v1, v3, v5);
        assertThat(result).isEmpty();
    }

    @Test
    public void test6Deep() {
        SimpleGraph sg = new SimpleGraph(4);
        sg.m_adjacency = new int[][] {
                {0,1,1,0,0},
                {1,0,1,0,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.DepthFirstSearch (0, 3);
        //List<Vertex> expect = List.of(v1, v3, v5);
        assertThat(result).isEmpty();
    }

    @Test
    public void test7Deep() {
        SimpleGraph sg = new SimpleGraph(7);
        sg.m_adjacency = new int[][] {
                {0,1,1,0,0,0,0},
                {1,0,0,1,1,0,0},
                {1,0,0,0,0,1,0},
                {0,1,0,0,1,0,0},
                {0,1,0,1,0,0,1},
                {0,0,1,0,0,0,1},
                {0,0,0,0,1,0,1}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6, v7
        };
        List<Vertex> result = sg.DepthFirstSearch (0, 6);
        List<Vertex> expect = List.of(v1, v2, v4, v5, v7);
        //или 1367
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test8Deep() {
        SimpleGraph sg = new SimpleGraph(6);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,0,1},
                {1,0,1,0,0,0},
                {0,1,0,1,0,0},
                {0,0,1,0,1,0},
                {0,0,0,1,0,1},
                {1,0,0,0,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6
        };
        List<Vertex> result = sg.DepthFirstSearch (0, 3);
        List<Vertex> expect = List.of(v1, v2, v3, v4);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test9Deep() {
        SimpleGraph sg = new SimpleGraph(3);
        sg.m_adjacency = new int[][] {
                {0,1,1},
                {1,0,1},
                {1,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        sg.vertex = new Vertex[] {
                v1, v2, v3
        };
        List<Vertex> result = sg.DepthFirstSearch (0, 0);
        List<Vertex> expect = List.of(v1, v2, v3, v1);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test10Deep() {
        SimpleGraph sg = new SimpleGraph(4);
        sg.m_adjacency = new int[][] {
                {0,1,1,1},
                {1,0,0,0},
                {1,0,0,1},
                {1,0,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4
        };
        List<Vertex> result = sg.DepthFirstSearch (0, 0);
        List<Vertex> expect = List.of(v1, v3, v4, v1);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test11Deep() {
        SimpleGraph sg = new SimpleGraph(6);
        sg.m_adjacency = new int[][] {
                {0,1,1,1,0,0},
                {1,0,0,0,0,0},
                {1,0,0,1,1,0},
                {1,0,1,0,0,1},
                {0,0,1,0,0,1},
                {0,0,0,1,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6
        };
        List<Vertex> result = sg.DepthFirstSearch (0, 0);
        List<Vertex> expect = List.of(v1, v3, v4, v1);
        assertThat(result).isEqualTo(expect);
    }


    //тест Deep без циклов

    @Test
    public void tes1DeepWOCycles() {
        SimpleGraph sg = new SimpleGraph(1);
        sg.m_adjacency = new int[][] {
                {0}
        };
        sg.vertex = new Vertex[] {
                new Vertex(1)
        };
        //System.out.println(sg.DepthFirstSearchWOCycles(0, 0));
        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 0);
        assertThat(result).isEmpty();
    }

    @Test
    public void tes2DeepWOCycles() {
        SimpleGraph sg = new SimpleGraph(1);
        sg.m_adjacency = new int[][] {
                {1}
        };
        Vertex v1 = new Vertex(1);
        sg.vertex = new Vertex[] {
                v1
        };
        //System.out.println(sg.DepthFirstSearchWOCycles(0, 0));
        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 0);
        List<Vertex> expect = List.of(v1, v1);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test3DeepWOCycles() {
        SimpleGraph sg = new SimpleGraph(5);
        sg.m_adjacency = new int[][] {
                {0,1,1,0,0},
                {1,0,1,1,0},
                {1,1,0,0,1},
                {0,1,0,0,1},
                {0,0,1,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5
        };
        //System.out.println(sg.DepthFirstSearchWOCycles(0, 0));
        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 4);
        List<Vertex> expect = List.of(v1, v2, v3, v5);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test4DeepWOCycles() {
        SimpleGraph sg = new SimpleGraph(3);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,0},
                {1,0,0,0,0},
                {0,0,0,0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        sg.vertex = new Vertex[] {
                v1, v2, v3
        };
        //System.out.println(sg.DepthFirstSearchWOCycles(1, 0));
        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 2);
        //List<Vertex> expect = List.of(v1, v3, v5);
        assertThat(result).isEmpty();
    }

    @Test
    public void test5DeepWOCycles() {
        SimpleGraph sg = new SimpleGraph(3);
        sg.m_adjacency = new int[][] {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,1,0,0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        sg.vertex = new Vertex[] {
                v1, v2, v3
        };
        //System.out.println(sg.DepthFirstSearchWOCycles(1, 0));
        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 2);
        //List<Vertex> expect = List.of(v1, v3, v5);
        assertThat(result).isEmpty();
    }

    @Test
    public void test6DeepWOCycles() {
        SimpleGraph sg = new SimpleGraph(4);
        sg.m_adjacency = new int[][] {
                {0,1,1,0,0},
                {1,0,1,0,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4
        };
        //System.out.println(sg.DepthFirstSearchWOCycles(0, 0));
        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 3);
        //List<Vertex> expect = List.of(v1, v3, v5);
        assertThat(result).isEmpty();
    }

    @Test
    public void test7DeepWOCycles() {
        SimpleGraph sg = new SimpleGraph(7);
        sg.m_adjacency = new int[][] {
                {0,1,1,0,0,0,0},
                {1,0,0,1,1,0,0},
                {1,0,0,0,0,1,0},
                {0,1,0,0,1,0,0},
                {0,1,0,1,0,0,1},
                {0,0,1,0,0,0,1},
                {0,0,0,0,1,0,1}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6, v7
        };
        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 6);
        List<Vertex> expect = List.of(v1, v2, v4, v5, v7);
        //или 1367
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test8DeepWOCycles() {
        SimpleGraph sg = new SimpleGraph(6);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,0,1},
                {1,0,1,0,0,0},
                {0,1,0,1,0,0},
                {0,0,1,0,1,0},
                {0,0,0,1,0,1},
                {1,0,0,0,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6
        };
        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 3);
        List<Vertex> expect = List.of(v1, v2, v3, v4);
        assertThat(result).isEqualTo(expect);
    }

    //тесты на циклы (не работают в этой версии метода)

//    @Test
//    public void test9DeepWOCycles() {
//        SimpleGraph sg = new SimpleGraph(3);
//        sg.m_adjacency = new int[][] {
//                {0,1,1},
//                {1,0,1},
//                {1,1,0}
//        };
//        Vertex v1 = new Vertex(1);
//        Vertex v2 = new Vertex(2);
//        Vertex v3 = new Vertex(3);
//        sg.vertex = new Vertex[] {
//                v1, v2, v3
//        };
//        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 0);
//        List<Vertex> expect = List.of(v1, v2, v3, v1);
//        assertThat(result).isEqualTo(expect);
//    }
//
//    @Test
//    public void test10DeepWOCycles() {
//        SimpleGraph sg = new SimpleGraph(4);
//        sg.m_adjacency = new int[][] {
//                {0,1,1,1},
//                {1,0,0,0},
//                {1,0,0,1},
//                {1,0,1,0}
//        };
//        Vertex v1 = new Vertex(1);
//        Vertex v2 = new Vertex(2);
//        Vertex v3 = new Vertex(3);
//        Vertex v4 = new Vertex(4);
//        sg.vertex = new Vertex[] {
//                v1, v2, v3, v4
//        };
//        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 0);
//        List<Vertex> expect = List.of(v1, v3, v4, v1);
//        assertThat(result).isEqualTo(expect);
//    }
//
//    @Test
//    public void test11DeepWOCycles() {
//        SimpleGraph sg = new SimpleGraph(6);
//        sg.m_adjacency = new int[][] {
//                {0,1,1,1,0,0},
//                {1,0,0,0,0,0},
//                {1,0,0,1,1,0},
//                {1,0,1,0,0,1},
//                {0,0,1,0,0,1},
//                {0,0,0,1,1,0}
//        };
//        Vertex v1 = new Vertex(1);
//        Vertex v2 = new Vertex(2);
//        Vertex v3 = new Vertex(3);
//        Vertex v4 = new Vertex(4);
//        Vertex v5 = new Vertex(5);
//        Vertex v6 = new Vertex(6);
//        sg.vertex = new Vertex[] {
//                v1, v2, v3, v4, v5, v6
//        };
//        List<Vertex> result = sg.DepthFirstSearchWOCycles (0, 0);
//        List<Vertex> expect = List.of(v1, v3, v4, v1);
//        assertThat(result).isEqualTo(expect);
//    }

    //тесты на уязвимость графов, WeakVertices

    @Test
    public void tes1WeakVertices() {
        SimpleGraph sg = new SimpleGraph(1);
        sg.m_adjacency = new int[][] {
                {0}
        };
        Vertex v1 = new Vertex(1);
        sg.vertex = new Vertex[] {
                v1
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.WeakVertices();
        List<Vertex> expect = List.of(v1);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void tes2WeakVertices() {
        SimpleGraph sg = new SimpleGraph(1);
        sg.m_adjacency = new int[][] {
                {1}
        };
        Vertex v1 = new Vertex(1);
        sg.vertex = new Vertex[] {
                v1
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.WeakVertices();
        List<Vertex> expect = List.of(v1);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test3WeakVertices() {
        SimpleGraph sg = new SimpleGraph(2);
        sg.m_adjacency = new int[][] {
                {0,1},
                {1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        sg.vertex = new Vertex[] {
                v1, v2
        };
        List<Vertex> result = sg.WeakVertices();
        List<Vertex> expect = List.of(v1, v2);
        assertThat(result).containsExactlyInAnyOrder(v1, v2);
    }

    @Test
    public void test4WeakVertices() {
        SimpleGraph sg = new SimpleGraph(2);
        sg.m_adjacency = new int[][] {
                {0,0},
                {0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        sg.vertex = new Vertex[] {
                v1, v2
        };
        //System.out.println(sg.DepthFirstSearch(0, 0));
        List<Vertex> result = sg.WeakVertices();
        List<Vertex> expect = List.of(v1, v2);
        assertThat(result).containsExactlyInAnyOrder(v1, v2);
    }

    @Test
    public void test5WeakVertices() {
        SimpleGraph sg = new SimpleGraph(3);
        sg.m_adjacency = new int[][] {
                {0,1,0},
                {1,0,0},
                {0,0,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        sg.vertex = new Vertex[] {
                v1, v2, v3
        };
        List<Vertex> result = sg.WeakVertices();
        List<Vertex> expect = List.of(v1, v2, v3);
        assertThat(result).containsExactlyInAnyOrder(v1, v2, v3);
    }

    @Test
    public void test6WeakVertices() {
        SimpleGraph sg = new SimpleGraph(3);
        sg.m_adjacency = new int[][] {
                {0,0,0},
                {0,0,1},
                {0,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        sg.vertex = new Vertex[] {
                v1, v2, v3
        };
        List<Vertex> result = sg.WeakVertices();
        List<Vertex> expect = List.of(v1, v2, v3);
        assertThat(result).containsExactlyInAnyOrder(v1, v2, v3);
    }

    @Test
    public void test7WeakVertices() {
        SimpleGraph sg = new SimpleGraph(5);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,1},
                {1,0,1,0,0},
                {0,1,0,1,0},
                {0,0,1,0,1},
                {1,0,0,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5
        };
        List<Vertex> result = sg.WeakVertices();
        List<Vertex> expect = List.of(v1, v2, v3, v4, v5);
        assertThat(result).containsExactlyInAnyOrder(v1, v2, v3, v4, v5);
    }

    @Test
    public void test8WeakVertices() {
        SimpleGraph sg = new SimpleGraph(7);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,1,0,0},
                {1,0,1,0,0,1,1},
                {0,1,0,1,0,0,1},
                {0,0,1,0,1,0,1},
                {1,0,0,1,0,0,0},
                {0,1,0,0,0,0,1},
                {0,1,1,1,0,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6, v7
        };
        List<Vertex> result = sg.WeakVertices();
        List<Vertex> expect = List.of(v1,v5);
        assertThat(result).containsExactlyInAnyOrder(v1, v5);
    }

    @Test
    public void test9WeakVertices() {
        SimpleGraph sg = new SimpleGraph(7);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,1,1,0},
                {1,0,1,0,0,1,1},
                {0,1,0,1,0,0,1},
                {0,0,1,0,1,0,1},
                {1,0,0,1,0,0,0},
                {1,1,0,0,0,0,1},
                {0,1,1,1,0,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6, v7
        };
        List<Vertex> result = sg.WeakVertices();
        List<Vertex> expect = List.of(v5);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test10WeakVertices() {
        SimpleGraph sg = new SimpleGraph(7);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,1,1,0},
                {1,0,1,0,0,1,1},
                {0,1,0,1,0,0,1},
                {0,0,1,0,1,0,1},
                {1,0,0,1,0,1,0},
                {1,1,0,0,1,0,1},
                {0,1,1,1,0,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6, v7
        };
        List<Vertex> result = sg.WeakVertices();
        assertThat(result).isEmpty();
    }

    @Test
    public void test11WeakVertices() {
        SimpleGraph sg = new SimpleGraph(7);
        sg.m_adjacency = new int[][] {
                {0,1,0,0,1,1,0},
                {1,0,1,0,0,1,1},
                {0,1,0,1,0,0,1},
                {0,0,1,0,1,0,1},
                {1,0,0,1,0,1,1},
                {1,1,0,0,1,0,1},
                {0,1,1,1,1,1,0}
        };
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        sg.vertex = new Vertex[] {
                v1, v2, v3, v4, v5, v6, v7
        };
        List<Vertex> result = sg.WeakVertices();
        assertThat(result).isEmpty();
    }
}