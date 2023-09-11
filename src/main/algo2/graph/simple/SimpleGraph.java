package main.algo2.graph.simple;

import java.util.*;

class Vertex
{
    public int Value;
    public boolean Hit;
    public Vertex(int val)
    {
        Value = val;
        Hit = false;
    }

    public ArrayList<Vertex> track = new ArrayList<>();

    @Override
    public String toString() {
        return "Vertex{" +
                "Value=" + Value +
                '}';
    }
}

class SimpleGraph
{
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size)
    {
        max_vertex = size;
        m_adjacency = new int [size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value)
    {
        for (int v = 0; v < max_vertex; v++) {
            if (vertex[v] == null) {
                vertex[v] = new Vertex(value);
                break;
            }
        }
        // ваш код добавления новой вершины
        // с значением value
        // в незанятую позицию vertex
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v)
    {
        vertex[v] = null;
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[i][v] = 0;
            m_adjacency[v][i] = 0;
        }
        // ваш код удаления вершины со всеми её рёбрами
    }

    public boolean IsEdge(int v1, int v2)
    {
        // true если есть ребро между вершинами v1 и v2
        return m_adjacency[v1][v2] == 1 || m_adjacency[v2][v1] == 1;
    }

    public void AddEdge(int v1, int v2)
    {
        // добавление ребра между вершинами v1 и v2
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
    }

    public void RemoveEdge(int v1, int v2)
    {
        // удаление ребра между вершинами v1 и v2
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }

    //не работает с циклами
    public ArrayList<Vertex> DepthFirstSearchWOCycles(int VFrom, int VTo) {
        Deque<Vertex> vertexStack = new ArrayDeque<>();
        clearVerticesHitsAndTracks();
        vertex[VFrom].Hit = true;
        vertexStack.push(vertex[VFrom]);
        while (!vertexStack.isEmpty()) {
            Vertex currentVertex = vertexStack.peek();
            int currentVertexIndex = searchIndex(currentVertex);
            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[currentVertexIndex][i] == 1 && i == VTo) {
                    return formResultList(vertexStack, VTo);
                }
                if (m_adjacency[currentVertexIndex][i] == 1 && !vertex[i].Hit) {
                    vertex[i].Hit = true;
                    vertexStack.push(vertex[i]);
                    break;
                }
                if (i == max_vertex - 1) {
                    vertexStack.pop();
                }
            }
        }
        return new ArrayList<>();
    }

    //работает и при поиске цикла, за это - вакханалия в for) но вообще в код в принципе нагроможден, кажется) сравни с более поздней версией выше без циклов
    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        Deque<Vertex> vertexStack = new ArrayDeque<>();
        clearVerticesHitsAndTracks();
        Vertex currentVertex = vertex[VFrom];
        int currentVertexIndex = VFrom;
        boolean foundAdjacentVertex;
        while (currentVertex != null) {
            foundAdjacentVertex = false;
            if (!currentVertex.Hit) {
                currentVertex.Hit = true;
                vertexStack.push(currentVertex);
            }
            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[currentVertexIndex][i] != 1) {
                    continue;
                }
                if (VFrom == VTo && m_adjacency[VFrom][VFrom] == 1) {
                    return formResultList(vertexStack, VTo);
                }
                if (VFrom == VTo && i == VTo && vertexStack.size() <= 2) {
                    continue;
                }
                if (i == VTo) {
                    return formResultList(vertexStack, VTo);
                }
                if (!vertex[i].Hit) {
                    currentVertex = vertex[i];
                    currentVertexIndex = i;
                    foundAdjacentVertex = true;
                    break;
                }
            }
            if (!foundAdjacentVertex) {
                vertexStack.pop();
                currentVertex = vertexStack.peek();
                currentVertexIndex = searchIndex(currentVertex);
            }
        }
        return new ArrayList<>();
    }


    private int searchIndex(Vertex searchingVertex) {
        for (int i = 0; i < max_vertex; i++) {
            if (vertex[i] == searchingVertex) {
                return i;
            }
        }
        return -1;
    }

    private ArrayList<Vertex> formResultList(Deque<Vertex> vertexStack, int VTo) {
        vertexStack.push(vertex[VTo]);
        ArrayList<Vertex> resultList = new ArrayList<>(vertexStack);
        Collections.reverse(resultList);
        return resultList;
    }

    private void clearVerticesHitsAndTracks() {
        for (Vertex vertex : vertex) {
            vertex.Hit = false;
            vertex.track.clear();
        }
    }

    //не работает при поиске цикла, но зато лаконично
    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo)
    {
        Queue<Vertex> vertexQueue = new LinkedList<>();
        clearVerticesHitsAndTracks();
        vertex[VFrom].Hit = true;
        vertex[VFrom].track.add(vertex[VFrom]);
        vertexQueue.offer(vertex[VFrom]);
        while(!vertexQueue.isEmpty()) {
            Vertex currentVertex = vertexQueue.poll();
            int currentVertexIndex = searchIndex(currentVertex);
            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[currentVertexIndex][i] == 1 && i == VTo) {
                    currentVertex.track.add(vertex[i]);
                    return currentVertex.track;
                }
                if (m_adjacency[currentVertexIndex][i] == 1 && !vertex[i].Hit) {
                    vertex[i].Hit = true;
                    vertex[i].track.addAll(currentVertex.track);
                    vertex[i].track.add(vertex[i]);
                    vertexQueue.offer(vertex[i]);
                }
            }
        }
        return new ArrayList<>();
    }
}