//
//  ProfileMenuCell.swift
//  InstagramClone
//
//  Created by Shohei Maeno on 2019/06/30.
//  Copyright © 2019 Shohei Maeno. All rights reserved.
//

import UIKit

class ProfileMenuCell: UICollectionViewCell {
    
    let menuImageView = UIImageView().setCustomImage(#imageLiteral(resourceName: "post"))
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        addSubview(menuImageView)
        menuImageView.anchorToCenterX()
        menuImageView.anchorToCenterY()
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
}
