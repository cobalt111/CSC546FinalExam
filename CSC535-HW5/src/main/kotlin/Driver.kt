fun main() {

    // region First Graph
    // First graph vertices
    val graphOneVertices = listOf(
        Vertex.S,
        Vertex.A,
        Vertex.B,
        Vertex.C,
        Vertex.D,
        Vertex.T)

    val graphOneEdges = mutableListOf(
        Edge(4, Vertex.S, Vertex.A),
        Edge(6, Vertex.S, Vertex.B),
        Edge(2, Vertex.A, Vertex.C),
        Edge(1, Vertex.A, Vertex.D),
        Edge(2, Vertex.B, Vertex.A),
        Edge(2, Vertex.B, Vertex.D),
        Edge(3, Vertex.C, Vertex.T),
        Edge(1, Vertex.C, Vertex.D),
        Edge(7, Vertex.D, Vertex.T)
    )

    val graphOneDirectedEdgeLookup = HashMap<Vertex, List<Edge>>()

    // Edges from S
    var graphOneVertexSpecificEdges = mutableListOf<Edge>()
    graphOneVertexSpecificEdges.add(Edge(4, Vertex.S, Vertex.A))
    graphOneVertexSpecificEdges.add(Edge(6, Vertex.S, Vertex.B))
    graphOneDirectedEdgeLookup[Vertex.S] = graphOneVertexSpecificEdges.toList()

    // Edges from A
    graphOneVertexSpecificEdges = mutableListOf<Edge>()
    graphOneVertexSpecificEdges.add(Edge(2, Vertex.A, Vertex.C))
    graphOneVertexSpecificEdges.add(Edge(1, Vertex.A, Vertex.D))
    graphOneDirectedEdgeLookup[Vertex.A] = graphOneVertexSpecificEdges.toList()

    // Edges from B
    graphOneVertexSpecificEdges = mutableListOf<Edge>()
    graphOneVertexSpecificEdges.add(Edge(2, Vertex.B, Vertex.A))
    graphOneVertexSpecificEdges.add(Edge(2, Vertex.B, Vertex.D))
    graphOneDirectedEdgeLookup[Vertex.B] = graphOneVertexSpecificEdges.toList()

    // Edges from C
    graphOneVertexSpecificEdges = mutableListOf<Edge>()
    graphOneVertexSpecificEdges.add(Edge(3, Vertex.C, Vertex.T))
    graphOneVertexSpecificEdges.add(Edge(1, Vertex.C, Vertex.D))
    graphOneDirectedEdgeLookup[Vertex.C] = graphOneVertexSpecificEdges.toList()

    // Edges from D
    graphOneVertexSpecificEdges = mutableListOf<Edge>()
    graphOneVertexSpecificEdges.add(Edge(7, Vertex.D, Vertex.T))
    graphOneDirectedEdgeLookup[Vertex.D] = graphOneVertexSpecificEdges.toList()

    // Edges from t
    graphOneVertexSpecificEdges = mutableListOf<Edge>()
    graphOneDirectedEdgeLookup[Vertex.T] = graphOneVertexSpecificEdges.toList()

    val firstGraph = Graph(graphOneVertices, graphOneEdges, graphOneDirectedEdgeLookup)
    // endregion

    // region Second Graph
    // Second graph vertices
    val graphTwoVertices = listOf(
        Vertex.A,
        Vertex.B,
        Vertex.C,
        Vertex.D,
        Vertex.E
    )

    val graphTwoEdges = listOf(
        Edge(10, Vertex.A, Vertex.B),
        Edge(5, Vertex.A, Vertex.E),
        Edge(1, Vertex.B, Vertex.C),
        Edge(2, Vertex.B, Vertex.E),
        Edge(4, Vertex.C, Vertex.D),
        Edge(6, Vertex.D, Vertex.C),
        Edge(7, Vertex.D, Vertex.A),
        Edge(3, Vertex.E, Vertex.B),
        Edge(9, Vertex.E, Vertex.C),
        Edge(2, Vertex.E, Vertex.D)
    )

    val graphTwoDirectedEdgeLookup = HashMap<Vertex, List<Edge>>()

    // Edges from A
    var graphTwoVertexSpecificEdges = mutableListOf<Edge>()
    graphTwoVertexSpecificEdges.add(Edge(10, Vertex.A, Vertex.B))
    graphTwoVertexSpecificEdges.add(Edge(5, Vertex.A, Vertex.E))
    graphTwoDirectedEdgeLookup[Vertex.A] = graphTwoVertexSpecificEdges.toList()

    // Edges from B
    graphTwoVertexSpecificEdges = mutableListOf<Edge>()
    graphTwoVertexSpecificEdges.add(Edge(1, Vertex.B, Vertex.C))
    graphTwoVertexSpecificEdges.add(Edge(2, Vertex.B, Vertex.E))
    graphTwoDirectedEdgeLookup[Vertex.B] = graphTwoVertexSpecificEdges.toList()

    // Edges from C
    graphTwoVertexSpecificEdges = mutableListOf<Edge>()
    graphTwoVertexSpecificEdges.add(Edge(4, Vertex.C, Vertex.D))
    graphTwoDirectedEdgeLookup[Vertex.C] = graphTwoVertexSpecificEdges.toList()

    // Edges from D
    graphTwoVertexSpecificEdges = mutableListOf<Edge>()
    graphTwoVertexSpecificEdges.add(Edge(6, Vertex.D, Vertex.C))
    graphTwoVertexSpecificEdges.add(Edge(7, Vertex.D, Vertex.A))
    graphTwoDirectedEdgeLookup[Vertex.D] = graphTwoVertexSpecificEdges.toList()

    // Edges from E
    graphTwoVertexSpecificEdges = mutableListOf<Edge>()
    graphTwoVertexSpecificEdges.add(Edge(3, Vertex.E, Vertex.B))
    graphTwoVertexSpecificEdges.add(Edge(9, Vertex.E, Vertex.C))
    graphTwoVertexSpecificEdges.add(Edge(2, Vertex.E, Vertex.D))
    graphTwoDirectedEdgeLookup[Vertex.E] = graphTwoVertexSpecificEdges.toList()

    val secondGraph = Graph(graphTwoVertices, graphTwoEdges, graphTwoDirectedEdgeLookup)
    // endregion

    // region Third Graph
    // Third graph vertices
    val graphThreeVertices = listOf(
        Vertex.A,
        Vertex.B,
        Vertex.C,
        Vertex.D,
        Vertex.E,
        Vertex.F,
        Vertex.G,
        Vertex.H,
        Vertex.J,
        Vertex.K
    )

    val graphThreeEdges = mutableListOf(
        Edge(1, Vertex.A, Vertex.B),
        Edge(1, Vertex.A, Vertex.E),
        Edge(1, Vertex.B, Vertex.A),
        Edge(1, Vertex.E, Vertex.A),
        Edge(1, Vertex.B, Vertex.C),
        Edge(1, Vertex.C, Vertex.B),
        Edge(1, Vertex.C, Vertex.G),
        Edge(4, Vertex.C, Vertex.J),
        Edge(3, Vertex.C, Vertex.F),
        Edge(1, Vertex.G, Vertex.C),
        Edge(4, Vertex.J, Vertex.C),
        Edge(3, Vertex.F, Vertex.C),
        Edge(1, Vertex.G, Vertex.H),
        Edge(5, Vertex.E, Vertex.D),
        Edge(1, Vertex.D, Vertex.H),
        Edge(2, Vertex.D, Vertex.J),
        Edge(1, Vertex.E, Vertex.G),
        Edge(1, Vertex.D, Vertex.K),
        Edge(1, Vertex.H, Vertex.G),
        Edge(5, Vertex.D, Vertex.E),
        Edge(1, Vertex.H, Vertex.D),
        Edge(2, Vertex.J, Vertex.D),
        Edge(1, Vertex.G, Vertex.E),
        Edge(1, Vertex.K, Vertex.D),
        Edge(1, Vertex.F, Vertex.K)
    )

    val graphThreeEdgeLookup = HashMap<Vertex, List<Edge>>()

    // Edges from A
    var graphThreeVertexSpecificEdges = mutableListOf<Edge>()
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.A, Vertex.B))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.A, Vertex.E))
    graphThreeEdgeLookup[Vertex.A] = graphThreeVertexSpecificEdges.toList()

    // Edges from B
    graphThreeVertexSpecificEdges = mutableListOf<Edge>()
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.B, Vertex.A))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.B, Vertex.C))
    graphThreeEdgeLookup[Vertex.B] = graphThreeVertexSpecificEdges.toList()

    // Edges from C
    graphThreeVertexSpecificEdges = mutableListOf<Edge>()
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.C, Vertex.B))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.C, Vertex.G))
    graphThreeVertexSpecificEdges.add(Edge(4, Vertex.C, Vertex.J))
    graphThreeVertexSpecificEdges.add(Edge(3, Vertex.C, Vertex.F))
    graphThreeEdgeLookup[Vertex.C] = graphThreeVertexSpecificEdges.toList()

    // Edges from D
    graphThreeVertexSpecificEdges = mutableListOf<Edge>()
    graphThreeVertexSpecificEdges.add(Edge(5, Vertex.D, Vertex.E))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.D, Vertex.H))
    graphThreeVertexSpecificEdges.add(Edge(2, Vertex.D, Vertex.J))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.D, Vertex.K))
    graphThreeEdgeLookup[Vertex.D] = graphThreeVertexSpecificEdges.toList()

    // Edges from E
    graphThreeVertexSpecificEdges = mutableListOf<Edge>()
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.E, Vertex.A))
    graphThreeVertexSpecificEdges.add(Edge(5, Vertex.E, Vertex.D))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.E, Vertex.G))
    graphThreeEdgeLookup[Vertex.E] = graphThreeVertexSpecificEdges.toList()

    // Edges from F
    graphThreeVertexSpecificEdges = mutableListOf<Edge>()
    graphThreeVertexSpecificEdges.add(Edge(3, Vertex.F, Vertex.C))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.F, Vertex.K))
    graphThreeEdgeLookup[Vertex.F] = graphThreeVertexSpecificEdges.toList()

    // Edges from G
    graphThreeVertexSpecificEdges = mutableListOf<Edge>()
    graphThreeVertexSpecificEdges.add(Edge(3, Vertex.G, Vertex.C))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.G, Vertex.E))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.G, Vertex.H))
    graphThreeEdgeLookup[Vertex.G] = graphThreeVertexSpecificEdges.toList()

    // Edges from H
    graphThreeVertexSpecificEdges = mutableListOf<Edge>()
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.H, Vertex.D))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.H, Vertex.G))
    graphThreeEdgeLookup[Vertex.H] = graphThreeVertexSpecificEdges.toList()
    
    // Edges from J
    graphThreeVertexSpecificEdges = mutableListOf<Edge>()
    graphThreeVertexSpecificEdges.add(Edge(4, Vertex.J, Vertex.C))
    graphThreeVertexSpecificEdges.add(Edge(2, Vertex.J, Vertex.D))
    graphThreeEdgeLookup[Vertex.J] = graphThreeVertexSpecificEdges.toList()

    // Edges from K
    graphThreeVertexSpecificEdges = mutableListOf<Edge>()
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.K, Vertex.D))
    graphThreeVertexSpecificEdges.add(Edge(1, Vertex.K, Vertex.F))
    graphThreeEdgeLookup[Vertex.K] = graphThreeVertexSpecificEdges.toList()

    val thirdGraph = Graph(graphThreeVertices, graphThreeEdges, graphThreeEdgeLookup)
    // endregion

    var solution: HashMap<Vertex, Int>
    for (i in 1..6) {
        solution = when (i) {
            1 -> {
                println("First Graph, Dijkstra")
                firstGraph.findShortestDijkstraPathFrom(Vertex.S)
            }
            2 -> {
                println("First Graph, Bellman-Ford")
                firstGraph.findShortestBellmanFordPathFrom(Vertex.S)
            }
            3 -> {
                println("Second Graph, Dijkstra")
                secondGraph.findShortestDijkstraPathFrom(Vertex.A)
            }
            4 -> {
                println("Second Graph, Bellman-Ford")
                secondGraph.findShortestBellmanFordPathFrom(Vertex.A)
            }
            5 -> {
                println("Third Graph, Dijkstra")
                thirdGraph.findShortestDijkstraPathFrom(Vertex.A)
            }
            6 -> {
                println("Third Graph, Bellman-Ford")
                thirdGraph.findShortestBellmanFordPathFrom(Vertex.A)
            }
            else -> hashMapOf()
        }
        for (vertex in solution.toSortedMap())
            println(vertex.key.name + ": " + vertex.value)
        println()
    }
}