//
//  ViewController.swift
//  SampleDataStorage
//
//  Created by Katsuhiro Asaka on 2020/01/20.
//  Copyright © 2020 Katsuhiro Asaka. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var textField: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        // UserDefaultsの参照
        let userDefaults = UserDefaults.standard
        // textというキーを指定して保存していた値を取り出す
        if let value = userDefaults.string(forKey: "text") {
            textField.text = value
        }
    }

    @IBAction func tapActionButton(_ sender: Any) {
        // UserDefaultsの参照
        let userDefaults = UserDefaults.standard
        // textというキーで値を保存する
        userDefaults.set(textField.text, forKey: "text")
        // UserDefaultsへの値の保存を明示的に行う
        userDefaults.synchronize()
    }
    
}

