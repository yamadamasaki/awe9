# GEMINI Directory Overview

This directory (`/Volumes/MyBook/Projects/awe9/gemini`) serves as the dedicated workspace for the Gemini AI agent within the `awe9` (Alternative Working Environment 9) project. Its primary purpose is to store operational data, conversational logs, and summarized knowledge pertinent to Gemini's activities.

## Directory Contents:

-   **`dialogues/`**: This subdirectory is used to record the complete interactions between the user and the Gemini agent. Each session's dialogue is intended to be logged here, providing a historical record of discussions, instructions, and outcomes. These logs are primarily for the user's reference and accountability.
-   **`summaries/`**: This subdirectory stores concise summaries of important sessions, key decisions, and acquired knowledge. It functions as Gemini's long-term memory, allowing the agent to reference past contexts, understand evolving project requirements, and maintain continuity across interactions. Gemini is expected to read these summaries at the beginning of each session to quickly grasp the current project state and context.

## Usage:

This directory is integral to the Gemini agent's operation within the `awe9` project.

-   **For the Gemini Agent:**
    -   Consult `summaries/` at the start of each session to recall previous contexts and decisions.
    -   Record full dialogues in `dialogues/` as instructed or automatically at session end.
    -   Update `summaries/` with critical information or decisions for long-term memory.
-   **For the User:**
    -   Review `dialogues/` for a detailed history of interactions with Gemini.
    -   Understand the context and ongoing knowledge base of Gemini by examining `summaries/`.

This structure ensures that Gemini maintains an organized and accessible record of its contributions and learned information, fostering more efficient and informed collaboration within the `awe9` project.

## GitHub Project Identification:

When referring to GitHub Projects, you can generally use the project's **Number** (e.g., `4`) for convenience with CLI commands. However, the project's **ID** (e.g., `PVT_kwHNkD3OATt8Gg`) is a more robust and globally unique identifier. Both can be used to reference a project, but using the Number is often simpler for direct `gh` CLI interactions.