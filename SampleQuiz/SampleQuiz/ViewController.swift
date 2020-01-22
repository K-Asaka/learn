//
//  ViewController.swift
//  SampleQuiz
//
//  Created by Katsuhiro Asaka on 2020/01/22.
//  Copyright © 2020 Katsuhiro Asaka. All rights reserved.
//

import UIKit
import AudioToolbox

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


    @IBAction func tapSystemSound(_ sender: Any) {
        // システムサウンド1000番を鳴らしつつバイブレーションを振動させる
        // マナーモードの場合はバイブレーションのみとなる
        AudioServicesPlaySystemSoundWithCompletion(1000) {
                // ここにはサウンドが鳴り終わったあとに呼ばれる処理を記述する
        }
    }
}

