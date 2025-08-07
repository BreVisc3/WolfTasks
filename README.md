# WolfTasks - Task Management System
## Overview
WolfTasks is a robust task management system built with Java following the Model-View-Controller (MVC) architecture. This project demonstrates core object-oriented principles and advanced Java features to implement a hierarchical task management system with specialized task lists, custom collection implementations, and persistent data storage.

## Key Features
* Notebook-centric organization with multiple task lists

* Specialized task list types:

  - Standard TaskList for general tasks

  - ActiveTaskList that dynamically aggregates active tasks

* Custom collection implementations:

  - SortedList (sorted linked list)

  - SwapList (dynamic array with swap capability)

* File I/O operations for saving/loading notebooks

* Task-list relationships where tasks can belong to multiple lists

* Recurring task support with automatic regeneration

## Architecture & Design Patterns
### Model-View-Controller (MVC)
* Model:

  - Notebook (manages collections of task lists)

  - Task (core task entity)

  - AbstractTaskList (base for task list types)

  - TaskList/ActiveTaskList (concrete implementations)

* View: Separate GUI implementation (not included in this model core)

* Controller: Mediates between view and model

### Key Class Relationships

```
Notebook
├── SortedList<TaskList> (custom sorted collection)
├── ActiveTaskList (specialized task list)
└── AbstractTaskList (current task list)
    │
    ├── TaskList
    │   └── SwapList<Task> (custom dynamic array)
    │
    └── ActiveTaskList
        └── Aggregates active tasks from all lists
```
### Custom Collections
1. SortedList:

    - Linked list implementation maintaining sorted order

    - O(n) insertion complexity

    - Generic type requiring Comparable elements

    - Used for maintaining alphabetically sorted task lists

2. SwapList:

    - Dynamic array implementation with O(1) random access

    - Implements ISwapList interface with swap capability

    - Used for efficient task reordering operations

## Core Functionality
### Notebook Management
* Create/rename notebooks with validation

* Maintain change state (isChanged flag)

* Save notebooks to file via NotebookWriter

* Manage multiple task lists in sorted order

### Task Operations
```
Task task = new Task("Submit Report", "Final project submission", true, true);
task.setActive(false);
task.completeTask(); // Handles recurrence
```

### Specialized Task Lists
ActiveTaskList:

* Automatically aggregates all active tasks

* Immutable name ("Active Tasks")

* Prohibits direct task addition (only active tasks appear)

* Updates dynamically when task states change

## Design Highlights
1. Abstraction & Inheritance:

    - AbstractTaskList provides common task list functionality

    - TaskList and ActiveTaskList implement specialized behaviors

2. Encapsulation:

    - Strict validation in setters (e.g., setNotebookName())

    - Controlled mutability through access modifiers

3. Polymorphism:

    - Unified interface for different task list types

    - ActiveTaskList overrides addTask() with custom behavior

4. Exception Handling:

    - Comprehensive input validation

    - Custom exceptions for business rule violations

## Technical Specifications
* Java Version: 8+

* Dependencies: Standard Java SE API only

* Persistence: Custom file format via NotebookWriter

* Data Structures: Custom linked list and dynamic array implementations

## How to Extend
1. Add new task list types by extending AbstractTaskList

2. Implement new views using the model's observer pattern

3. Enhance persistence by extending NotebookWriter/NotebookReader

4. Add task prioritization by modifying SortedList comparator

This implementation demonstrates strong object-oriented design principles, custom algorithm implementation, and clean separation of concerns - making it an excellent showcase of Java development skills for potential employers.
