//
//  Extension+UIButton.swift
//  InstagramClone
//
//  Created by Shohei Maeno on 2019/06/30.
//  Copyright © 2019 Shohei Maeno. All rights reserved.
//

import UIKit

extension UIButton {
    
    func setBackgroundColor(_ color: UIColor) -> UIButton {
        self.backgroundColor = color
        return self
    }
    
    func setBorderColor(_ color: UIColor) -> UIButton {
        self.layer.borderColor = color.cgColor
        return self
    }
    
    func setBorderWidth(_ width: CGFloat) -> UIButton {
        self.layer.borderWidth = width
        return self
    }
    
    func setCornerRadius(_ radius: CGFloat) -> UIButton {
        self.layer.cornerRadius = radius
        return self
    }
    
    func setCustomImage(_ image: UIImage, _ state: UIControl.State) -> UIButton {
        self.setImage(image.withRenderingMode(.alwaysOriginal), for: state)
        return self
    }
    
    func setTitleText(_ text: String) -> UIButton {
        self.setTitle(text, for: .normal)
        return self
    }
    
    func setTitleTextColor(_ color: UIColor) -> UIButton {
        self.setTitleColor(color, for: .normal)
        return self
    }
    
    func setFont(ofSize: CGFloat, weight: UIFont.Weight = .regular) -> UIButton {
        self.titleLabel?.font = UIFont.systemFont(ofSize: ofSize, weight: weight)
        return self
    }
    
}
