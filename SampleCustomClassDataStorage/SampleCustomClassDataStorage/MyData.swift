//
//  MyData.swift
//  SampleCustomClassDataStorage
//
//  Created by Katsuhiro Asaka on 2020/01/20.
//  Copyright © 2020 Katsuhiro Asaka. All rights reserved.
//

import Foundation

class MyData: NSObject, NSSecureCoding {
    
    static var supportsSecureCoding: Bool {
        return true
    }
    
    var valueString: String?
    
    override init() {
        
    }
    
    func encode(with aCoder: NSCoder) {
        aCoder.encode(valueString, forKey: "valueString")
    }
    
    required init?(coder aDecoder: NSCoder) {
        valueString = aDecoder.decodeObject(forKey: "valueString") as? String
    }

    
}
