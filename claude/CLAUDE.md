# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

awe9 (Alternative Working Environment 9) is a collaborative project for incubating Deep Software Engineering (深ソフトウェア工学, https://github.com/yamadamasaki/deep-software-engineering). Currently in the documentation and planning phase with no executable code yet. The technology stack is undecided.

Two AI assistants collaborate on this project: Claude (`/claude`) and Gemini (`/gemini`). Claude Code operates within the `/claude` directory.

## Repository Structure

```
/                   # Repository root (one level up from this CLAUDE.md)
├── premises/       # Project prerequisites and assumptions (shared, written primarily by the owner)
├── materials/      # Third-party resources: PDFs, markdown, URLs (shared)
├── artifacts/      # Project deliverables and documents (shared)
├── claude/         # Claude's private workspace (THIS directory)
│   ├── dialogues/  # Conversation logs (private to Claude)
│   └── summaries/  # Session memory and key points (private to Claude)
└── gemini/         # Gemini's private workspace (private to Gemini)
```

**Shared** directories (`premises/`, `materials/`, `artifacts/`) are accessible to all members. **Private** directories (`claude/dialogues`, `claude/summaries`) are not shared with Gemini.

## Language and Communication

- The official language (公用語) is **Japanese**. All communication and documentation should be in Japanese, except for technical terms and proper nouns which may remain in their original language.
- Flag any terminology inconsistencies (用語のブレ) when noticed.

## Session Workflow

### At session start
- Read `claude/summaries/` to recall past context.

### During session
- When the user says **「記録して」**: record the dialogue and update summaries.
- When the user says **「思い出して」**: recall past context from summaries.
- Self-document when meaningful dialogue occurs during a session.

### At session end
- Record dialogue to `claude/dialogues/` if meaningful discussion occurred.
- Update `claude/summaries/` with key decisions and insights.

## Dialogue File Format

- Format: Markdown with YAML frontmatter
- Frontmatter fields: `date`, `participants`, `topic`, `related` (related documents)
- Headings: `## Human` / `## Claude` to distinguish speakers
- Filename: `YYYY-MM-DD-topic-in-english.md`
- Record utterances verbatim

## Git

- Remote: `github` (https://github.com/yamadamasaki/awe9.git)
- Branch: `main`
