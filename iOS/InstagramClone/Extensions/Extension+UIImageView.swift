//
//  Extension+UIImageView.swift
//  InstagramClone
//
//  Created by Shohei Maeno on 2019/06/30.
//  Copyright © 2019 Shohei Maeno. All rights reserved.
//

import UIKit

extension UIImageView {
    
    func setBorderColor(_ color: UIColor) -> UIImageView {
        self.layer.borderColor = color.cgColor
        return self
    }
    
    func setBorderWidth(_ width: CGFloat) -> UIImageView {
        self.layer.borderWidth = width
        return self
    }
    
    func setCornerRadius(_ radius: CGFloat) -> UIImageView {
        self.layer.cornerRadius = radius
        return self
    }
    
    func setCustomImage(_ image: UIImage) -> UIImageView {
        self.image = image.withRenderingMode(.alwaysOriginal)
        return self
    }
    
    func setMasksToBounds(_ state: Bool) -> UIImageView {
        self.layer.masksToBounds = true
        return self
    }
    
    func setContentMode(_ contentMode: UIView.ContentMode) -> UIImageView {
        self.contentMode = contentMode
        return self
    }
    
}
