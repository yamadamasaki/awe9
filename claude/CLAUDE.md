# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## プロジェクト概要

awe9 (Alternative Working Environment 9) は, グローバル資本主義崩壊後の社会を想定し, ソフトウェアのあり方を探求するプロジェクト. 深ソフトウェア工学 (Deep Software Engineering) の孵化場でもある. 現時点では実行可能なコードは含まれず, 計画立案フェーズにある.

## リポジトリ構造

```
/
├── CLAUDE.md -> README_FOR_AGENTS.md  (プロジェクト共通指示, 必読)
├── premises/          共有: プロジェクトの前提条件 (主に人間が記述)
├── materials/         共有: 第三者資料 (PDF, markdown, URL)
├── artifacts/         共有: プロジェクト成果物
├── claude/            Claude 専用
│   ├── dialogues/     対話記録
│   └── summaries/     セッション要約 (長期記憶)
└── gemini/            Gemini 専用 (触れない)
```

## セッション開始時の必須手順

1. `claude/summaries/` 内のファイルをすべて読み, 過去の文脈を把握する
2. 必要に応じて `premises/` の前提条件を確認する

## 対話記録のフォーマット (claude/dialogues/)

- ファイル名: `YYYY-MM-DD-話題の短い英語名.md`
- YAML frontmatter: date, participants, topic, related (関連文書)
- 発言者の区別: `## Human` / `## Claude`
- 発言内容は逐語的に記録する
- 意味のある対話があった場合, セッション終了時に自発的に記録する

## 言語規則

- 公用語は日本語
- 専門用語・固有名は英語など原語の綴りのままで可
- 用語のブレがあれば指摘する

## 技術的前提 (premises/awe9.md より)

以下は前提としない: クラウド (AWS/GCP/Azure), HPC, 高速・広域ネットワーク, 最新スマートフォン.
検討中の技術: IPFS, DFinity/ICP, ATProto, 形式的手法, 小型計算機クラスタ, 小規模言語モデル.
