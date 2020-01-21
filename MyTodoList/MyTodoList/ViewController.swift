//
//  ViewController.swift
//  MyTodoList
//
//  Created by Katsuhiro Asaka on 2020/01/20.
//  Copyright © 2020 Katsuhiro Asaka. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {

    // ToDoを格納した配列
    var todoList = [MyTodo]()
    
    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // 保存しているToDoの読み込み処理
        let userDefaults = UserDefaults.standard
        if let storedTodoList = userDefaults.object(forKey: "todoList") as? Data {
            do {
                if let unarchiveTodoList = try NSKeyedUnarchiver.unarchivedObject(ofClasses: [NSArray.self, MyTodo.self], from: storedTodoList) as? [MyTodo] {
                    todoList.append(contentsOf: unarchiveTodoList)
                }
            } catch {
                // エラー処理なし
            }
        }
    }

    // +ボタンをタップした時に呼ばれる処理
    @IBAction func tapAddButton(_ sender: Any) {
        // アラートダイアログを生成
        let alertController = UIAlertController(title: "ToDo追加", message: "ToDoを入力してください", preferredStyle: UIAlertController.Style.alert)
        
        // テキストエリアを追加
        alertController.addTextField(configurationHandler: nil)
        // OKボタンを追加
        let okAction = UIAlertAction(title: "OK", style: UIAlertAction.Style.default) {
            (action: UIAlertAction) in
            // OKボタンがタップされたときの処理
            if let textField = alertController.textFields?.first {
                // ToDoの配列に入力値を挿入。先頭に挿入する
                let myTodo = MyTodo()
                myTodo.todoTitle = textField.text!
                self.todoList.insert(myTodo, at: 0)
                // テーブルに行が追加されたことをテーブルに通知
                self.tableView.insertRows(at: [IndexPath(row: 0, section: 0)],
                                          with: UITableView.RowAnimation.right)
                // ToDoの保存処理
                let userDefaults = UserDefaults.standard
                // Data型にシリアライズする
                do {
                    let data = try NSKeyedArchiver.archivedData(withRootObject: self.todoList, requiringSecureCoding: true)
                    userDefaults.set(data, forKey: "todoList")
                    userDefaults.synchronize()
                } catch {
                    // エラー処理なし
                }
            }
        }
        // OKボタンがタップされたときの処理
        alertController.addAction(okAction)
        // CANCELボタンがタップされたときの処理
        let cancelButton = UIAlertAction(title: "CANCEL", style: UIAlertAction.Style.cancel, handler: nil)
        // CANCELボタンを追加
        alertController.addAction(cancelButton)
        // アラートダイアログを表示
        present(alertController, animated: true, completion: nil)
    }
    
    // テーブルの行数を返却する
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // ToDo配列の長さを返却する
        return todoList.count
    }
    
    // テーブルの行ごとのセルを返却する
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // Storyboardで指定したtodoCell識別子を利用して再利用可能なセルを取得する
        let cell = tableView.dequeueReusableCell(withIdentifier: "todoCell", for: indexPath)
        // 行番号に合ったToDoの情報を取得
        let myTodo = todoList[indexPath.row]
        // セルのラベルにToDoのタイトルをセット
        cell.textLabel?.text = myTodo.todoTitle
        // セルのチェックマーク状態をセット
        if myTodo.todoDone {
            // チェックあり
            cell.accessoryType = UITableViewCell.AccessoryType.checkmark
        } else {
            // チェックなし
            cell.accessoryType = UITableViewCell.AccessoryType.none
        }
        return cell
    }
    
    // セルをタップしたときの処理
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let myTodo = todoList[indexPath.row]
        if myTodo.todoDone {
            // 完了済みの場合は未完了に変更
            myTodo.todoDone = false
        } else {
            // 未完の場合は完了済みに変更
            myTodo.todoDone = true
        }
        // セルの状態を変更
        tableView.reloadRows(at: [indexPath], with: UITableView.RowAnimation.fade)
        // データ保存。Data型にシリアライズする
        do {
            let data: Data = try NSKeyedArchiver.archivedData(withRootObject: todoList, requiringSecureCoding: true)
            // UserDefaultsに保存
            let userDefaults = UserDefaults.standard
            userDefaults.set(data, forKey: "todoList")
            userDefaults.synchronize()
        } catch {
            // エラー処理なし
        }
    }

}

// 独自クラスをシリアライズする際には、NSObjectを継承しNSSecureCodingプロトコルに準拠する必要がある
class MyTodo: NSObject, NSSecureCoding {
    
    static var supportsSecureCoding: Bool {
        return true
    }
    
    // ToDoのタイトル
    var todoTitle: String?
    // ToDoを完了したかどうかを表すフラグ
    var todoDone: Bool = false
    // コンストラクタ
    override init() {
    }
    // NSCodingプロトコルに宣言されているデシリアライズ処理。デコード処理とも呼ばれる
    required init?(coder aDecoder: NSCoder) {
        todoTitle = aDecoder.decodeObject(forKey: "todoTitle") as? String
        todoDone = aDecoder.decodeBool(forKey: "todoDone")
    }
    // NSCodingプロトコルに宣言されているシリアライズ処理。エンコード処理とも呼ばれる
    func encode(with aCoder: NSCoder) {
        aCoder.encode(todoTitle, forKey: "todoTitle")
        aCoder.encode(todoDone, forKey: "todoDone")
    }
}
