import groovy.transform.TailRecursive

class Node {
    Node next = null
    def content
    
    public String toString() {
        content
    }
}

Node append(Node left, Node right) {
    if (!right) return left
    if (!left) return right

    if (!left.next) left.next = right
    else left.next = append(left.next, right)

    return left
}

@TailRecursive
Node append2(Node left, Node right) {
    if (left == null) {
        println("not left $left $right")
        return right
    } else if (right == null) {
        println("not right $left $right")
        return left
    } else {
        left.next = right
        return append2(left, right.next) 
    }
}

def l3 = new Node(content: 'l3')
def l2 = new Node(content: 'l2', next: l3)
def l1 = new Node(content: 'l1', next: l2)

def r2 = new Node(content: 'r2')
def r1 = new Node(content: 'r1', next: r2)

void print(l) {
    println(l)
    if(l.next) 
        print(l.next)
} 
println('l')
print(l1)
println('r')
print(r1)
println('---')
def merged = append2(l1, r1)
println('---')
println(merged.content)
println(merged.next)
println('merged')
println(merged)