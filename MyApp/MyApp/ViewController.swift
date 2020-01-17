//
//  ViewController.swift
//  MyApp
//
//  Created by Katsuhiro Asaka on 2020/01/18.
//  Copyright © 2020 Katsuhiro Asaka. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var label: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        // 引き算の計算結果をvalue変数に設定
        let value: Int = 10 - 1
        // label.textに値を設定
        label.text = " \(value)"
    }


}

