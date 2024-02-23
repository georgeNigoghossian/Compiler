# DART Language Compiler

## Project Overview

The DART Language Compiler is a project aimed at allowing the development of mobile applications at a high level of abstraction,</br>
making it possible to generate application code for various technologies including web, Android, iOS, and desktop.</br>
In this project, we have implemented a translator for the DART language.

## Directory Structure

- lib</br>
Contains library files essential for the DART language compiler.

- ast</br>
The ast directory encompasses components related to the Abstract Syntax Tree (AST). It includes subdirectories for navigation, nodes, and variables, containing essential structures for representing the DART language.

- CodeGeneration</br>
This directory includes components crucial for code generation.

- gen</br>
Generated code produced during the compilation process.

- images</br>
Image files utilized within the project.

- Splitter</br>
Components dedicated to code splitting.

- tests</br>
The tests directory contains subdirectories for different types of tests, such as code generation, declarations (Boolean, Double, Integer, String), evaluations, scopes_test, and semantic_errors.

- visitors</br>
The visitors directory encompasses visitors for both DART language and Flutter-specific code generation. It includes subdirectories for DartVisitors and FlutterVisitor.

- src</br>
Parallel to the out/production/compiler-1 directory, the src directory holds the source code for the project.
