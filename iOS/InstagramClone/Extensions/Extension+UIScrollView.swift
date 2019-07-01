//
//  Extension+UIScrollView.swift
//  InstagramClone
//
//  Created by Shohei Maeno on 2019/06/30.
//  Copyright © 2019 Shohei Maeno. All rights reserved.
//

import UIKit

extension UIScrollView {
    func updateContentView() {
        contentSize.height = subviews.sorted(by: { $0.frame.maxY < $1.frame.maxY }).last?.frame.maxY ?? contentSize.height
    }
}
