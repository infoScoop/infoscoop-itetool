# プログラムの実行確認環境

* OS: Windows 7
* JDK: 1.7

# ファイル一覧

* infoscoop-sitetool.jar: OSSサイトのダウンロードページで使用するファイルの情報（名前、サイズ、最終更新日時、MD5ハッシュ値）をCSVファイルに出力するプログラムです。
* makecsv.properties: 上記プログラムで使用するプロパティファイルです。
* README.md: このファイルです。


# プログラムの実行について

プログラムを実行する前に「makecsv.properties」ファイル内の各プロパティを適切な値に変更してください。  
以下のコマンドでプログラムが実行されます。

```
java -jar ./infoscoop-itetool.jar <makecsv.propertiesのパス>
ex) java -jar ./infoscoop-itetool.jar ./makecsv.properties
```

プロパティのデフォルトパスは、「./makecsv.properties」です。

# makecsv.properties

* directory_path: モジュールファイルが配置されているディレクトリのパスを入力してください。
* old_csv_name: 古いCSVファイル名を入力してください。プログラムが削除します。
* new_csv_name: 出力するCSVファイル名を入力してください。
* order_patterns: この値をもとにファイルの並び順を決定します。ファイル名をJavaの正規表現で表し、「,」区切りで入力してください。左が先頭になります。
* use_csv_header: CSVファイルの1行目にフィールド名を表示させたい場合は「true」を入力してください。
