##topo sort solution
1. kahn algorithm
(suit for partial order and full order /// also solve the None direction graph and DAG)
check every vertex with 0 indegree, remove its edge from matrix and indegree of its next vertex. 
After remove some edges, indegree of some vertex become 0. Then visit these new vertexs with 0 indegree. The visiting order of vertexes is the topo order we want

pseudo code:

        L ← Empty list that will contain the sorted elements

        S ← Set of all nodes with no incoming edge

        while S is non-empty do

            remove a node n from S
            
            add n to tail of L
            for each node m with an edge e from n to m do
                remove edge e from the graph
                if m has no other incoming edges then
                    insert m into S
        if graph has edges then
            return error (graph has at least one cycle)
        else 
            return L (a topologically sorted order)

2. dfs algorithm

compare to kahn algorithm, dfs is more simple but requires provement process

L ← Empty list that will contain the sorted nodes

S ← Set of all nodes with no outgoing edges

for each node n in S do

    visit(n) 

function visit(node n)

    if n has not been visited yet then

        mark n as visited

        for each node m with an edgefrom m to ndo

            visit(m)

        add n to L ///this is key step of recursion



