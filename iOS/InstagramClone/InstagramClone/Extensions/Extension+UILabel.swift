//
//  Extension+UILabel.swift
//  InstagramClone
//
//  Created by Shohei Maeno on 2019/06/30.
//  Copyright © 2019 Shohei Maeno. All rights reserved.
//

import UIKit

extension UILabel {
    
    func setFont(ofSize: CGFloat, weight: UIFont.Weight) -> UILabel {
        self.font = UIFont.systemFont(ofSize: ofSize, weight: weight)
        return self
    }
    
    func setTextColor(_ color: UIColor) -> UILabel {
        self.textColor = color
        return self
    }
    
    func setText(_ text: String) -> UILabel {
        self.text = text
        return self
    }
    
}
