//
//  ViewController.swift
//  SampleAnimation
//
//  Created by Katsuhiro Asaka on 2020/01/22.
//  Copyright © 2020 Katsuhiro Asaka. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var targetView: UIView!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func tapStartButton(_ sender: Any) {
        // ビューの角を丸める処理をアニメーションで表現する
        let animation = CABasicAnimation(keyPath: "cornerRadius")
        animation.timingFunction = CAMediaTimingFunction(name: CAMediaTimingFunctionName.default)
        // 変更前の値は0
        animation.fromValue = 0
        // 変更後の値は20
        animation.toValue = 20
        // アニメーションの時間は1秒
        animation.duration = 1
        // アニメーションをレイヤーに追加する
        targetView.layer.add(animation, forKey: "cornerRadius")
        // 変更後も角丸を維持
        targetView.layer.cornerRadius = 20
        
        self.targetView.alpha = 1
        UIView.animate(withDuration: 1.0) {
            self.targetView.alpha = 0
        }
        
    }
}

