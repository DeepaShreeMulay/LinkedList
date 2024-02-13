package com.example.linkedlist

class LinkedList {

    private var head: Node? = null

    fun addAtBeginning(value: String) {
        val newItem = Node(value)
        newItem.next = head
        head = newItem
    }

    fun addAtEnd(value: String) {
        val newItem = Node(value)
        if (head == null) {
            head = newItem
            return
        }
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = newItem
    }

    fun addInMiddle(value: String) {
        if (head == null) {
            addAtBeginning(value)
            return
        }

        val newNode = Node(value)
        var slow: Node? = null
        var fast: Node? = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = if (slow == null) {
                head
            } else {
                slow.next
            }
            fast = fast.next?.next
        }

        if (slow == null) {
            // If the list has only one element
            newNode.next = head
            head = newNode
        } else {
            newNode.next = slow.next
            slow.next = newNode
        }
    }


    fun getAllItems(): List<Node> {
        val items = mutableListOf<Node>()
        var current = head
        while (current != null) {
            items.add(current)
            current = current.next
        }
        return items
    }

    fun clear() {
        head = null
    }
}

