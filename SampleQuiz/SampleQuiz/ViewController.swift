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
    
    @IBAction func tapCustomSound(_ sender: Any) {
        // 指定するサウンドファイルは再生時間が30秒以下であること
        let soundUrl = Bundle.main.url(forResource: "custom", withExtension: "mp3")
        // サウンドIDを登録するための変数を用意
        var soundId: SystemSoundID = 0
        // サウンドファイルを登録してサウンドIDを取得
        AudioServicesCreateSystemSoundID(soundUrl! as CFURL, &soundId)
        // 取得したサウンドIDを使用してサウンドを鳴らす
        AudioServicesPlaySystemSoundWithCompletion(soundId) {
            // ここにはサウンドが鳴り終わったあとに呼ばれる処理を記述する
        }
    }
}

