# Contributing to Waterproof

The following is a set of guidelines for contributing to this Application, which are hosted in the [Yellowme Organization](https://yellowme.gitbooks.io/playbook/content/) on Bitbucket.
These are just guidelines, not strict rules. Use your best judgment, and feel free to propose changes to this document in a pull request.

#### Table Of Contents

[What should I know before I get started?](#what-should-i-know-before-i-get-started)
* [Architecture](#an-architecture)
* [Project structure](#project-structure)

[How Can I Contribute?](#how-can-i-contribute)
* [Development Workflow](#development-workflow)
* [Reporting Bugs](#reporting-bugs)
* [Pull Requests](#pull-requests)

[Styleguides](#styleguides)
  * [Git Commit Messages](#git-commit-messages)
  * [Android Styleguide](#android-styleguide)
  * [Documentation Styleguide](#documentation-styleguide)

[Additional Notes](#additional-notes)
  * [Issue and Pull Request Labels](#issue-and-pull-request-labels)
  
## Project Structure

```
├─ mvp
  ├─ activity
  ├─ adapter
  ├─ fragment
  ├─ staticlist
  ├─ lists
  └─ repositories
├─ managers
└─ validator
```

## What should I know before I get started?

### Architecture

For now, the project does not have a Software Architecture Document (SAD). We use a variant of Clean Architecture combined with the MVP pattern and the Repository Pattern. The major difference relies on the use of basic Interactors instead of Use Cases. We encourage the developer to research about this topic. However, here are some useful links:
* [MVP and Interactors by Platzi](https://www.youtube.com/watch?v=qWh1QlRpKxk)
* [Google Architecture Blueprint](https://github.com/googlesamples/android-architecture/tree/todo-mvp-clean/)
* [A Clean Architecture approach for Android](http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/)
* [Clean Architecture by Uncle Bob](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)

## How Can I Contribute?

### Development Workflow

In order to work on this projects it is necessary to review and adopt the steps specified on the [Workflow Document](./WORKFLOW.md)

### Reporting Bugs

This section guides you through submitting a bug report for FMD. Following these guidelines helps maintainers and the development team understand any report made, reproduce the behavior and find related reports.

Before creating bug reports, please check [this list](#before-submitting-a-bug-report) as you might find out that you don't need to create one. When you are creating a bug report, please [include as many details as possible](#how-do-i-submit-a-good-bug-report). If you'd like, you can use [this template](#template-for-submitting-bug-reports) to structure the information.

#### Before Submitting A Bug Report

* **Make sure is a bug.** You might be able to find the cause of the problem and fix things yourself. Most importantly, check if you can reproduce the problem in the latest version of the app.
* **Perform a search** to see if the problem has already been reported. If it has, add a comment to the existing issue instead of opening a new one.

#### How Do I Submit A (Good) Bug Report?

Bugs are tracked as GitLab issues. After you've determined a bug, create an issue on the application repository and provide the following information.

Explain the problem and include additional details to help maintainers reproduce the problem:

* **Use a clear and descriptive title** for the issue to identify the problem.
* **Describe the exact steps which reproduce the problem** in as many details as possible. For example, start by explaining how you started the Android App, e.g. which was the state of the network connection, gps or the device in general. When listing steps, **don't just say what you did, but explain how you did it**. For example, if you .., explain if you ..., and if so ...?
* **Provide specific examples to demonstrate the steps**. Include links to files, other projects, or copy/pasteable snippets, which you use in those examples. If you're providing snippets in the issue, use [Markdown code blocks](https://gitlab.com/gitlab-org/gitlab-ce/blob/master/doc/user/markdown.md#code-and-syntax-highlighting).
* **Describe the behavior you observed after following the steps** and point out what exactly is the problem with that behavior.
* **Explain which behavior you expected to see instead and why.**
* **Include screenshots and animated GIFs** which show you following the described steps and clearly demonstrate the problem. **Include this only if it is completely necessary.**
* **If you're reporting that App crashed**, include a crash report with a stack trace from the LogCat. Include the crash report in the issue in a [code block](https://gitlab.com/gitlab-org/gitlab-ce/blob/master/doc/user/markdown.md#code-and-syntax-highlighting).
* **If the problem wasn't triggered by a specific action**, describe what you were doing before the problem happened and share more information using the guidelines below.

Provide more context by answering these questions:

* **Did the problem start happening recently** (e.g. after updating to a new version of a third party library) or was this always a problem?
* If the problem started happening recently, **can you reproduce the problem in an older version of the app?** What's the most recent version in which the problem doesn't happen?

Include details about your configuration and environment:

* **Which version of app are you using?** You can get the exact version in `versionName` variable on the `app/build.gradle'` file.
* **What's the name and version of the OS you're using**?
* **Are you running an emulator?** If so, which one are you using?

#### Template For Submitting Bug Reports

    [Short description of problem here]

**Reproduction Steps:**

    1. [First Step]
    2. [Second Step]
    3. [Other Steps...]

**Expected behavior:**

    [Describe expected behavior here]

**Observed behavior:**

    [Describe observed behavior here]

**Screenshots and GIFs (Only if necessary)**

    ![Screenshots and GIFs which follow reproduction steps to demonstrate the problem](url)]

**App version:** [Enter App version here]

**Android OS and version: (Only if necessary)** [Enter OS name and version here]

**Additional information:**

* Problem can be easily reproduced: [Yes/No]
* Problem started happening recently, didn't happen in an older version of the App: [Yes/No]
* Problem can be reliably reproduced, doesn't happen randomly: [Yes/No]

### Pull Requests

  * Include screenshots and animated GIFs in your pull request whenever possible.
  * Follow the [Android Styleguide](#android-styleguide).
  * Document new code based on the
    [Documentation Styleguide](#documentation-styleguide)
  * About dependencies...
  * About class variables..
  * About methods..

## Styleguides

### Git Commit Messages

* Use the present tense:
  * "Add feature" :white_check_mark:
  * not "Added feature" :negative_squared_cross_mark:
* Use the imperative mood:
  * "Move cursor to..." :white_check_mark:
  * not "Moves cursor to..." :negative_squared_cross_mark:
* Limit the first line to 72 characters or less.
* Reference issues and pull requests liberally.

### Android Styleguide

For now, the project is not using a Styleguide reference for particular elements of the Android Framework. This section may be more relevant in the future. We encourage the developer to try to adopt previous conventions on naming resources or code files that already exists on the code base.

### Documentation Styleguide

For now, the project is using the standard Javadoc style for writing documentation on class and methods. We encourage the developer to research about this topic. However, here are some useful links:
* [A styleguide](https://github.com/kijiproject/wiki/wiki/Javadoc-Style-Guide)
* [Tutorials Point: Java Documentation](https://www.tutorialspoint.com/java/java_documentation.htm)
* [Oracle Documentation](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html)