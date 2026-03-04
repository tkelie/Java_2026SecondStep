# Java Practice – Second Step (2026)

このリポジトリは、
**Java エンジニア復帰の第 2 段階の学習記録**です。

既存の [Java（基礎練習リポジトリ）](https://github.com/tkelie/Java_2026FirstStep) で
Stream / Date API / Optional / Comparator などをひととおり復習したため、
このリポジトリでは **テスト・設計・責務分離・CLI 化** など、
より実務寄りの力をつけることを目的としています。

---

## 🎯 学習の目的

* **JUnit（テスト駆動の基礎）** を理解する
* **例外設計と Optional の扱い** を習得する
* **クラス分割・責務の分離**（LogReader / Analyzer など）を身につける
* Stream API を **groupingBy / mapping など高度な使い方**へ発展させる
* 既存のログ問題を **CLI アプリとして動くツール化** する
* GitHub でコード管理し、復帰エンジニアとしての力を固める

---

## 📂 ディレクトリ構成

```
.
├── src/
│   ├── step1_junit/
│   ├── step2_exception/
│   ├── step3_validation/
│   ├── step4_refactor/
│   ├── step5_grouping/
│   └── step6_cli/
├── test/
│   └── （JUnit テスト）
└── README.md
```

---

## 🧩 練習ロードマップ（5〜7日で完了）

### **STEP 1：JUnit の基礎（テストの書き方）**

#### 🌱 練習 A-1：FizzBuzz をテストで検証：【実装済(2026/03/03)】

* `fizzBuzz(int n)` を作成
* 3, 5, 15 の倍数判定をテスト
* 初めての JUnit に最適

---

### **STEP 2：JUnit（例外パターンのテスト）**

#### 🌱 練習 A-2：配列の平均値のテスト：【実装済(2026/03/03)】

* 通常ケース
* 空配列で例外
* null のテスト
* → JUnit の例外検証を理解する

---

### **STEP 3：ログ欠落のバリデーション（ToDo ②）**

#### 🌱 練習 B-1：ログ欠落を検出する：【実装済(2026/03/04)】

* LOGIN → LOGOUT が無い場合
* Optional or 例外で扱う
* テスト対象として実務に近い

---

### **STEP 4：クラス分割（ToDo ③）**

#### 🌱 練習 C-1：ログ解析を責務ごとに分離する：【実装済(2026/03/04)】

* LogReader
* SessionAnalyzer
* Main
* → オブジェクト指向の基礎を固める

---

### **STEP 5：Stream → Map（関数型スタイル）**

#### 🌱 練習 D-1：ログを userId で groupBy

* groupingBy
* summingLong
* mapping / filtering
* → Java 8+ の関数型 API を実践

---

### **STEP 6：CLI アプリ化（ToDo ⑤）**

#### 🌱 練習 E-1：既存ログ解析を CLI ツール化

* `--file input.txt` を受け取る
* `--summary` 等のモード追加
* プレーン Java で CLI を実現

---

## 🧠 使用するモダン Java の機能

| 機能                 | 使用箇所                             |
| ------------------ | -------------------------------- |
| **JUnit 5**        | テスト駆動・例外検証                       |
| **Optional**       | 欠落ログの扱い                          |
| **Stream API（発展）** | groupingBy / mapping / filtering |
| **Comparator**     | ソート・分析処理                         |
| **java.time API**  | 日付ログの扱い                          |
| **責務分離（クラス分割）**    | LogReader / Analyzer             |
| **CLI 引数処理**       | `String[] args` の活用              |

---

## 🚀 今後の予定（ToDo）

* [ ] JUnit でテストしやすい設計へのリファクタリング
* [ ] ログ欠落時のエラー設計（例外 / Optional）
* [ ] CLI アプリのオプション強化
* [ ] グラフ出力（余裕があれば）
* [ ] Spring Boot 版の検討（将来的に）

---

## 💻 開発環境

* Java 25
* VSCode（Extension Pack for Java）
* GitHub（バージョン管理）
* Windows 11

---

---

---


## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
