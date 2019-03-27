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

    var graphOneEdges = mutableListOf<Edge>()
    val graphOneDirectedEdgeLookup = HashMap<Vertex, List<Edge>>()

    // Edges from S
    graphOneEdges.add(Edge(4, Vertex.S, Vertex.A))
    graphOneEdges.add(Edge(6, Vertex.S, Vertex.B))
    graphOneDirectedEdgeLookup[Vertex.S] = graphOneEdges.toList()

    // Edges from A
    graphOneEdges = mutableListOf<Edge>()
    graphOneEdges.add(Edge(2, Vertex.A, Vertex.C))
    graphOneEdges.add(Edge(1, Vertex.A, Vertex.D))
    graphOneDirectedEdgeLookup[Vertex.A] = graphOneEdges.toList()

    // Edges from B
    graphOneEdges = mutableListOf<Edge>()
    graphOneEdges.add(Edge(2, Vertex.B, Vertex.A))
    graphOneEdges.add(Edge(2, Vertex.B, Vertex.D))
    graphOneDirectedEdgeLookup[Vertex.B] = graphOneEdges.toList()

    // Edges from C
    graphOneEdges = mutableListOf<Edge>()
    graphOneEdges.add(Edge(3, Vertex.C, Vertex.T))
    graphOneEdges.add(Edge(1, Vertex.C, Vertex.D))
    graphOneDirectedEdgeLookup[Vertex.C] = graphOneEdges.toList()

    // Edges from D
    graphOneEdges = mutableListOf<Edge>()
    graphOneEdges.add(Edge(7, Vertex.D, Vertex.T))
    graphOneDirectedEdgeLookup[Vertex.D] = graphOneEdges.toList()

    // Edges from t
    graphOneEdges = mutableListOf<Edge>()
    graphOneDirectedEdgeLookup[Vertex.T] = graphOneEdges.toList()

    val firstGraph = Graph(graphOneVertices, graphOneEdges, graphOneDirectedEdgeLookup)
    // endregion

    // region Second Graph
    // Second graph vertices
    val graphTwoVertices = listOf(
        Vertex.A,
        Vertex.B,
        Vertex.C,
        Vertex.D,
        Vertex.E)

    var graphTwoEdges = mutableListOf<Edge>()
    val graphTwoDirectedEdgeLookup = HashMap<Vertex, List<Edge>>()

    // Edges from A
    graphTwoEdges.add(Edge(10, Vertex.A, Vertex.B))
    graphTwoEdges.add(Edge(5, Vertex.A, Vertex.E))
    graphTwoDirectedEdgeLookup[Vertex.A] = graphTwoEdges.toList()

    // Edges from B
    graphTwoEdges = mutableListOf<Edge>()
    graphTwoEdges.add(Edge(1, Vertex.B, Vertex.C))
    graphTwoEdges.add(Edge(2, Vertex.B, Vertex.E))
    graphTwoDirectedEdgeLookup[Vertex.B] = graphTwoEdges.toList()

    // Edges from C
    graphTwoEdges = mutableListOf<Edge>()
    graphTwoEdges.add(Edge(4, Vertex.C, Vertex.D))
    graphTwoDirectedEdgeLookup[Vertex.C] = graphTwoEdges.toList()

    // Edges from D
    graphTwoEdges = mutableListOf<Edge>()
    graphTwoEdges.add(Edge(6, Vertex.D, Vertex.C))
    graphTwoEdges.add(Edge(7, Vertex.D, Vertex.A))
    graphTwoDirectedEdgeLookup[Vertex.D] = graphTwoEdges.toList()

    // Edges from E
    graphTwoEdges = mutableListOf<Edge>()
    graphTwoEdges.add(Edge(3, Vertex.E, Vertex.B))
    graphTwoEdges.add(Edge(9, Vertex.E, Vertex.C))
    graphTwoEdges.add(Edge(2, Vertex.E, Vertex.D))
    graphTwoDirectedEdgeLookup[Vertex.E] = graphTwoEdges.toList()

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
        Vertex.K)

    var graphThreeEdges = mutableListOf<Edge>()
    val graphThreeEdgeLookup = HashMap<Vertex, List<Edge>>()

    // Edges from A
    graphThreeEdges.add(Edge(1, Vertex.A, Vertex.B))
    graphThreeEdges.add(Edge(1, Vertex.A, Vertex.E))
    graphThreeEdgeLookup[Vertex.A] = graphThreeEdges.toList()

    // Edges from B
    graphThreeEdges = mutableListOf<Edge>()
    graphThreeEdges.add(Edge(1, Vertex.B, Vertex.A))
    graphThreeEdges.add(Edge(1, Vertex.B, Vertex.C))
    graphThreeEdgeLookup[Vertex.B] = graphThreeEdges.toList()

    // Edges from C
    graphThreeEdges = mutableListOf<Edge>()
    graphThreeEdges.add(Edge(1, Vertex.C, Vertex.B))
    graphThreeEdges.add(Edge(1, Vertex.C, Vertex.G))
    graphThreeEdges.add(Edge(4, Vertex.C, Vertex.J))
    graphThreeEdgeLookup[Vertex.C] = graphThreeEdges.toList()

    // Edges from D
    graphThreeEdges = mutableListOf<Edge>()
    graphThreeEdges.add(Edge(5, Vertex.D, Vertex.E))
    graphThreeEdges.add(Edge(1, Vertex.D, Vertex.H))
    graphThreeEdges.add(Edge(2, Vertex.D, Vertex.J))
    graphThreeEdges.add(Edge(1, Vertex.D, Vertex.K))
    graphThreeEdgeLookup[Vertex.D] = graphThreeEdges.toList()

    // Edges from E
    graphThreeEdges = mutableListOf<Edge>()
    graphThreeEdges.add(Edge(1, Vertex.E, Vertex.A))
    graphThreeEdges.add(Edge(5, Vertex.E, Vertex.D))
    graphThreeEdges.add(Edge(1, Vertex.E, Vertex.G))
    graphThreeEdgeLookup[Vertex.E] = graphThreeEdges.toList()

    // Edges from F
    graphThreeEdges = mutableListOf<Edge>()
    graphThreeEdges.add(Edge(3, Vertex.F, Vertex.C))
    graphThreeEdges.add(Edge(1, Vertex.F, Vertex.K))
    graphThreeEdgeLookup[Vertex.F] = graphThreeEdges.toList()

    // Edges from G
    graphThreeEdges = mutableListOf<Edge>()
    graphThreeEdges.add(Edge(3, Vertex.G, Vertex.C))
    graphThreeEdges.add(Edge(1, Vertex.G, Vertex.E))
    graphThreeEdges.add(Edge(1, Vertex.G, Vertex.H))
    graphThreeEdgeLookup[Vertex.G] = graphThreeEdges.toList()

    // Edges from H
    graphThreeEdges = mutableListOf<Edge>()
    graphThreeEdges.add(Edge(1, Vertex.H, Vertex.D))
    graphThreeEdges.add(Edge(1, Vertex.H, Vertex.G))
    graphThreeEdgeLookup[Vertex.H] = graphThreeEdges.toList()
    
    // Edges from J
    graphThreeEdges = mutableListOf<Edge>()
    graphThreeEdges.add(Edge(4, Vertex.J, Vertex.C))
    graphThreeEdges.add(Edge(2, Vertex.J, Vertex.D))
    graphThreeEdgeLookup[Vertex.J] = graphThreeEdges.toList()

    // Edges from K
    graphThreeEdges = mutableListOf<Edge>()
    graphThreeEdges.add(Edge(1, Vertex.K, Vertex.D))
    graphThreeEdges.add(Edge(1, Vertex.K, Vertex.F))
    graphThreeEdgeLookup[Vertex.K] = graphThreeEdges.toList()

    val thirdGraph = Graph(graphThreeVertices, graphThreeEdges, graphThreeEdgeLookup)
    // endregion

    var solution: HashMap<Vertex, Int>
    for (i in 1..3) {
        solution = when (i) {
            1 -> firstGraph.findShortestDijkstraPathFrom(Vertex.S)
//            2 -> firstGraph.findShortestBellmanFordPathFrom(Vertex.S)
            2 -> secondGraph.findShortestDijkstraPathFrom(Vertex.A)
//            4 -> secondGraph.findShortestBellmanFordPathFrom(Vertex.A)
            3 -> thirdGraph.findShortestDijkstraPathFrom(Vertex.A)
//            6 -> thirdGraph.findShortestBellmanFordPathFrom(Vertex.A)
            else -> hashMapOf()
        }
        for (vertex in solution.toSortedMap())
            println(vertex.key.name + ": " + vertex.value)
        println()
    }
}