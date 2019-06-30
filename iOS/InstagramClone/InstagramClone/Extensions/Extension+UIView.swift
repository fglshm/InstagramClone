//
//  Extension+UIView.swift
//  InstagramClone
//
//  Created by Shohei Maeno on 2019/06/30.
//  Copyright © 2019 Shohei Maeno. All rights reserved.
//
import UIKit

extension UIView {
    
    func fillSuperView() {
        translatesAutoresizingMaskIntoConstraints = false
        
        if let topAnchor = superview?.safeAreaLayoutGuide.topAnchor {
            self.topAnchor.constraint(equalTo: topAnchor).isActive = true
        }
        
        if let leadingAnchor = superview?.leadingAnchor {
            self.leadingAnchor.constraint(equalTo: leadingAnchor).isActive = true
        }
        
        if let bottomAnchor = superview?.safeAreaLayoutGuide.bottomAnchor {
            self.bottomAnchor.constraint(equalTo: bottomAnchor).isActive = true
        }
        
        if let trailingAnchor = superview?.trailingAnchor {
            self.trailingAnchor.constraint(equalTo: trailingAnchor).isActive = true
        }
        
    }
    
    func anchor(top: NSLayoutYAxisAnchor?, left: NSLayoutXAxisAnchor?, bottom: NSLayoutYAxisAnchor?, right: NSLayoutXAxisAnchor?, padding: UIEdgeInsets = .zero, size: CGSize = .zero) {
        
        translatesAutoresizingMaskIntoConstraints = false
        
        if let top = top {
            if padding != .zero {
                let topPadding = padding.top
                self.topAnchor.constraint(equalTo: top, constant: topPadding).isActive = true
            } else {
                self.topAnchor.constraint(equalTo: top).isActive = true
            }
        }
        
        if let left = left {
            if padding != .zero {
                let paddingLeft = padding.left
                self.leadingAnchor.constraint(equalTo: left, constant: paddingLeft).isActive = true
            } else {
                self.leadingAnchor.constraint(equalTo: left).isActive = true
            }
        }
        
        if let bottom = bottom {
            if padding != .zero {
                let paddingBottom = padding.bottom
                self.bottomAnchor.constraint(equalTo: bottom, constant: -paddingBottom).isActive = true
            } else {
                self.bottomAnchor.constraint(equalTo: bottom).isActive = true
            }
        }
        
        if let right = right {
            if padding != .zero && padding.right != 0 {
                let paddingRight = padding.right
                self.trailingAnchor.constraint(equalTo: right, constant: -paddingRight).isActive = true
            } else {
                self.trailingAnchor.constraint(equalTo: right).isActive = true
            }
        }
        
        if size != .zero {
            
            let width = size.width
            let height = size.height
            
            if width != 0 {
                self.widthAnchor.constraint(equalToConstant: width).isActive = true
            }
            
            if height != 0 {
                self.heightAnchor.constraint(equalToConstant: height).isActive = true
            }
        }
        
        
    }
    
    func anchorToCenterX() {
        translatesAutoresizingMaskIntoConstraints = false
        
        if let centerXAnchor = superview?.centerXAnchor {
            self.centerXAnchor.constraint(equalTo: centerXAnchor).isActive = true
        }
    }
    
    func anchorToCenterY() {
        translatesAutoresizingMaskIntoConstraints = false
        
        if let centerYAnchor = superview?.centerYAnchor {
            self.centerYAnchor.constraint(equalTo: centerYAnchor).isActive = true
        }
    }
    
}
