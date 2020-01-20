//
//  ViewController.swift
//  SampleCustomClassDataStorage
//
//  Created by Katsuhiro Asaka on 2020/01/20.
//  Copyright © 2020 Katsuhiro Asaka. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // 画面表示時にデータを格納
        let userDefaults = UserDefaults.standard
        let data = MyData()
        data.valueString = "test"
        
        // シリアライズ処理
        do {
            let archiveData = try NSKeyedArchiver.archivedData(
                withRootObject: data, requiringSecureCoding: true)
            userDefaults.set(archiveData, forKey: "data")
            userDefaults.synchronize()
            
            // デシリアライズ処理
            if let storedData = userDefaults.object(forKey: "data") as? Data {
                if let unarchivedData = try NSKeyedUnarchiver.unarchivedObject(
                    ofClass: MyData.self, from: storedData) {
                    if let valueString = unarchivedData.valueString {
                        print("デシリアライズデータ: " + valueString)
                    }
                }
            }
        } catch {
            print("エラー \(error)")
        }
    }
}

