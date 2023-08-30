package main.algo2.graph.simple;

class Vertex
{
    public int Value;
    public Vertex(int val)
    {
        Value = val;
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
        // ��� ��� ���������� ����� �������
        // � ��������� value
        // � ��������� ������� vertex
    }

    // ����� � �����, ��������� v -- ������ �������
    // � ������  vertex
    public void RemoveVertex(int v)
    {
        vertex[v] = null;
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[i][v] = 0;
            m_adjacency[v][i] = 0;
        }
        // ��� ��� �������� ������� �� ����� � ������
    }

    public boolean IsEdge(int v1, int v2)
    {
        // true ���� ���� ����� ����� ��������� v1 � v2
        return m_adjacency[v1][v2] == 1 || m_adjacency[v2][v1] == 1;
    }

    public void AddEdge(int v1, int v2)
    {
        // ���������� ����� ����� ��������� v1 � v2
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
    }

    public void RemoveEdge(int v1, int v2)
    {
        // �������� ����� ����� ��������� v1 � v2
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }
}