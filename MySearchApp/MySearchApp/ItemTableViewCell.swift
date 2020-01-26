//
//  ItemTableViewCell.swift
//  MySearchApp
//
//  Created by Katsuhiro Asaka on 2020/01/26.
//  Copyright © 2020 Katsuhiro Asaka. All rights reserved.
//

import UIKit

class ItemTableViewCell: UITableViewCell {
    @IBOutlet weak var itemImageView: UIImageView!
    @IBOutlet weak var itemTitleLabel: UILabel!
    @IBOutlet weak var itemPriceLabel: UILabel!
    
    var itemUrl: String?    // 商品ページのURL。遷移先の画面で利用する
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
    
    override func prepareForReuse() {
        // 元々入っている情報を再利用時にクリア
        itemImageView.image = nil
    }
}
