# Java Practice – Second Step (2026)

このリポジトリは  
**Java エンジニア復帰の第2段階の学習記録**です。

既存の  
[Java_2026FirstStep](https://github.com/tkelie/Java_2026FirstStep)  
では

- Stream API
- Date & Time API
- Optional
- Comparator

など **Java 8+ のモダン構文の学習**を行いました。

本リポジトリではその続きとして、

**テスト・設計・責務分離・CLI ツール化**

といった、より **実務寄りの開発スキル**を身につけることを目的としています。

---

# 🎯 学習の目的

- **JUnit（テスト駆動の基礎）** を理解する
- **例外設計と Optional の扱い** を習得する
- **クラス分割・責務分離**（LogReader / Analyzer など）
- Stream API を **groupingBy / mapping など発展形へ**
- ログ解析コードを **CLIツールとして実行可能にする**
- GitHub でコード管理し、復帰エンジニアとしての力を固める

---

# 📂 ディレクトリ構成

```
.
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── step1_junit/
│   │       ├── step2_exception/
│   │       ├── step3_validation/
│   │       ├── step4_refactor/
│   │       ├── step5_grouping/
│   │       └── step6_cli/
│   └── test/
│       └── java/
│           ├── step1_junit/
│           ├── step2_exception/
│           ├── step3_validation/
│           ├── step4_refactor/
│           ├── step5_grouping/
│           └── step6_cli/
├── samplefile/
├── pom.xml
└── README.md
```

---

# 🧩 練習ロードマップ（5〜7日）

---

## STEP 1：JUnit 基礎

### 🌱 A-1：FizzBuzz テスト【実装済(2026/03/03)】

- fizzBuzz(int n) を実装
- JUnit で倍数判定をテスト

学習内容

- JUnit 基本構造
- assertEquals

---

## STEP 2：JUnit（例外テスト）

### 🌱 A-2：平均値計算【実装済(2026/03/03)】

テストケース

- 通常ケース
- 空配列
- null

学習内容

- `assertThrows`
- 例外パターンテスト

---

## STEP 3：ログ欠落の検証

### 🌱 B-1：ログ欠落検出【実装済(2026/03/04)】

LOGIN → LOGOUT の対応を確認。

ログ欠落時

- Optional
- 例外

で扱う。

---

## STEP 4：クラス分割

### 🌱 C-1：責務分離【実装済(2026/03/04)】

ログ解析をクラスごとに分離。

```
LogReader
SessionAnalyzer
Main
```

目的

- オブジェクト指向
- 責務分離

---

## STEP 5：Stream 集計

### 🌱 D-1：groupingBy 集計【実装済(2026/03/05)】

ログを `userId` ごとに集計。

実装クラス

```
LogReader
LogCounter
UserFinder
Main
```

使用API

- Stream API
- groupingBy
- counting
- filter

---

# STEP 6：CLI アプリ化（ToDo⑤）

### 🌱 E-1：ログ解析ツールの CLI 化【実装済(2026/03/06)】

FirstStep で作成したログ解析コードを  
**CLI ツールとして実行できる形に拡張**した。

---

## 実装クラス

```
CliParser
LogReader
LogCounter
UserFinder
Main
```

役割

**CliParser**

- `String[] args` を解析
- CLI オプションを `Map<String,String>` として取得

**LogReader**

- ログファイルを読み込み
- `Optional<List<Log>>` を返す

**LogCounter**

- `groupingBy + counting`
- ユーザーごとの LOGIN 回数集計

**UserFinder**

- `groupingBy + filter`
- LOGIN が複数回のユーザー抽出

**Main**

- CLIオプションに応じて処理実行
- `--help` で使用方法表示

---

# CLI オプション

```

--file <path>
解析するログファイル

--summary
ユーザー別 LOGIN 回数

--duplicate
LOGIN が複数回のユーザー

--help
CLI 使用方法表示

```

---

# 実行例

### LOGIN 回数集計

```

java -jar target/Java_2026SecondStep-1.0-SNAPSHOT.jar 
--file samplefile/step5.txt 
--summary

```

出力

```

bob : 1
charlie : 2
dinna : 1

```

---

### 重複 LOGIN ユーザー

```

java -jar target/Java_2026SecondStep-1.0-SNAPSHOT.jar 
--file samplefile/step5.txt 
--duplicate

```

出力

```

alice
charlie

```

---

# ログフォーマット

ログは以下の形式。

```

userId OPERATION

```

OPERATION

```

LOGIN
LOGOUT

```

### 例

```

alice LOGIN
alice LOGOUT
bob LOGIN
charlie LOGIN
charlie LOGOUT
alice LOGIN
charlie LOGIN

```

---

# 🧠 使用したモダン Java

| 機能 | 内容 |
|-----|-----|
| JUnit5 | テスト |
| Optional | 欠落ログ |
| Stream API | grouping / filter |
| record | ログデータ |
| enum | ログ種別 |
| Comparator | ソート |
| java.time | 時刻処理 |
| CLI 引数処理 | args |

---

# 🚀 今後の予定

- CLIオプション追加
- グラフ可視化
- Spring Boot 版検討

---

# 💻 開発環境

- Java 25
- Maven 3.9
- VSCode
- GitHub
- Windows 11
