class Graph(internal val vertices: List<Vertex>,
            internal val edges: List<Edge>,
            internal val edgeLookup: HashMap<Vertex, List<Edge>>) {

    fun findShortestDijkstraPathFrom(startVertex: Vertex): HashMap<Vertex, Int> {
        val distancesToVertices = HashMap<Vertex, Int>()
        for (vertex in vertices)
            distancesToVertices[vertex] = Int.MAX_VALUE
        distancesToVertices[startVertex] = 0

        val remainingVertices = vertices.toMutableList()

        while (!remainingVertices.isEmpty()) {
            var minimumDistance = Int.MAX_VALUE
            var minimumVertex = remainingVertices[0]
            for (vertex in remainingVertices) {
                if (distancesToVertices[vertex]!! < minimumDistance) {
                    minimumDistance = distancesToVertices[vertex]!!
                    minimumVertex = vertex
                }
            }
            remainingVertices.remove(minimumVertex)

            for (edge in edgeLookup[minimumVertex]!!.asIterable()) {
                val distance = distancesToVertices[minimumVertex]!! + edge.weight
                if (distance < distancesToVertices[edge.secondEnd]!!) {
                    distancesToVertices[edge.secondEnd] = distance
                }
            }
        }
        return distancesToVertices
    }


    fun findShortestBellmanFordPathFrom(startVertex: Vertex): HashMap<Vertex, Int> {
        val distancesToVertices = HashMap<Vertex, Int>()
        for (vertex in vertices)
            distancesToVertices[vertex] = Int.MAX_VALUE
        distancesToVertices[startVertex] = 0

        for (vertex in vertices)
            for (edge in edges) {
                val currentDistance = distancesToVertices[edge.firstEnd]!! + edge.weight
                if (currentDistance < distancesToVertices[edge.secondEnd]!!)
                    distancesToVertices[edge.secondEnd] = currentDistance
            }

        for (edge in edges)
            if (distancesToVertices[edge.firstEnd]!! + edge.weight < distancesToVertices[edge.secondEnd]!!)
                println("Negative cycle exists")

        return distancesToVertices
    }
}