package main.algo2.graph.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

class Vertex
{
    public int Value;
    public boolean Hit;
    public Vertex(int val)
    {
        Value = val;
        Hit = false;
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

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        Deque<Vertex> vertexStack = new ArrayDeque<>();
        Vertex currentVertex = vertex[VFrom];
        boolean foundAdjacentVertex;
        while (currentVertex != null) {
            foundAdjacentVertex = false;
            if (!currentVertex.Hit) {
                currentVertex.Hit = true;
                vertexStack.push(currentVertex);
            }
            int currentVertexIndex = searchIndex(currentVertex);
            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[currentVertexIndex][i] == 1 && vertex[i] == vertex[VTo]) {
                    vertexStack.push(vertex[VTo]);
                    ArrayList<Vertex> resultList = new ArrayList<>(vertexStack);
                    Collections.reverse(resultList);
                    return resultList;
                }
                if (m_adjacency[currentVertexIndex][i] == 1 && !vertex[i].Hit) {
                    currentVertex = vertex[i];
                    foundAdjacentVertex = true;
                    break;
                }
            }
            if (!foundAdjacentVertex) {
                vertexStack.pop();
                currentVertex = vertexStack.peek();
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
}