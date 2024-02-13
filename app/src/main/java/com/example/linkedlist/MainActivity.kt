package com.example.linkedlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var linkedList = LinkedList()
    private lateinit var linkedListTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddBeginning = findViewById<Button>(R.id.addBeginningButton)
        val btnAddMiddle = findViewById<Button>(R.id.addMiddleButton)
        val btnAddEnd = findViewById<Button>(R.id.addEndButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val valueInput = findViewById<EditText>(R.id.valueInput)
        linkedListTextView = findViewById(R.id.linkedListTextView)

        btnAddBeginning.setOnClickListener {
            val value = valueInput.text.toString()
            if (value.isNotEmpty()) {
                linkedList.addAtBeginning(value)
                valueInput.text.clear()
                displayLinkedList()
            }
        }

        btnAddMiddle.setOnClickListener {
            val value = valueInput.text.toString()
            if (value.isNotEmpty()) {
                linkedList.addInMiddle(value)
                valueInput.text.clear()
                displayLinkedList()
            }
        }

        btnAddEnd.setOnClickListener {
            val value = valueInput.text.toString()
            if (value.isNotEmpty()) {
                linkedList.addAtEnd(value)
                valueInput.text.clear()
                displayLinkedList()
            }
        }

        clearButton.setOnClickListener {
            linkedList.clear() // Clear the linked list
            displayLinkedList()
        }
    }

    private fun displayLinkedList() {
        val listItems = linkedList.getAllItems()
        val stringBuilder = StringBuilder()
        listItems.forEach {
            stringBuilder.append(it.value).append(" -> ")
        }
        linkedListTextView.text = stringBuilder.toString()
    }
}

