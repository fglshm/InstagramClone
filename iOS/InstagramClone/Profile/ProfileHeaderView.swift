//
//  ProfileHeaderView.swift
//  InstagramClone
//
//  Created by Shohei Maeno on 2019/06/30.
//  Copyright © 2019 Shohei Maeno. All rights reserved.
//

import UIKit

class ProfileHeaderView: UIView {
    
    fileprivate let imageWidth: CGFloat = UIScreen.main.bounds.width / 4
    fileprivate let padding: CGFloat = 16
    
    lazy var profileImageView: UIImageView = {
        let iv = UIImageView()
        iv.contentMode = .scaleAspectFill
        iv.layer.borderColor = UIColor.lightGray.cgColor
        iv.layer.borderWidth = 1
        iv.layer.cornerRadius = self.imageWidth / 2
        iv.layer.masksToBounds = true
        iv.image = #imageLiteral(resourceName: "person11")
        return iv
    }()
    
    let plusButton = UIButton(type: .system)
        .setCustomImage(#imageLiteral(resourceName: "plus"), .normal)
        .setBackgroundColor(.white)
        .setBorderColor(.white)
        .setBorderWidth(2)
        .setCornerRadius(12)
    
    lazy var postCountLabel = makeLabel(text: "16", size: 16, weight: .semibold)
    lazy var followerCountLabel = makeLabel(text: "10", size: 16, weight: .semibold)
    lazy var followingCountLabel = makeLabel(text: "19", size: 16, weight: .semibold)
    
    lazy var postLabel = makeLabel(text: "Posts", size: 12)
    lazy var followerLabel = makeLabel(text: "Followers", size: 12)
    lazy var followingLabel = makeLabel(text: "Following", size: 12)
    
    lazy var usernameLabel = makeLabel(text: "Grace Johnston", size: 12, weight: .medium)
    lazy var captionLabel = makeLabel(text: "Hi.", size: 12)
    
    let editButton = UIButton(type: .system)
        .setBackgroundColor(.white)
        .setCornerRadius(4)
        .setBorderColor(#colorLiteral(red: 0.6000000238, green: 0.6000000238, blue: 0.6000000238, alpha: 1))
        .setBorderWidth(0.5)
        .setFont(ofSize: 12, weight: .medium)
        .setTitleText("Edit Profile")
        .setTitleTextColor(.black)
    
    init(data: ProfileData?) {
        super.init(frame: .zero)
        
        addSubview(profileImageView)
        addSubview(plusButton)
        
        let postStackView = makeStackView(labels: [postCountLabel, postLabel])
        let followerStackView = makeStackView(labels: [followerCountLabel, followerLabel])
        let followingStackView = makeStackView(labels: [followingCountLabel, followingLabel])
        
        let statsStackView = UIStackView(arrangedSubviews: [postStackView, followerStackView, followingStackView])
            .setAxis(.horizontal)
            .setAlignment(.center)
            .setDistribution(.fillEqually)
        
        let detailStackView = UIStackView(arrangedSubviews: [usernameLabel, captionLabel])
            .setAxis(.vertical)
            .setAlignment(.leading)
            .setSpacing(2)
            .setDistribution(.fillEqually)
        
        profileImageView.anchor(top: topAnchor, left: leadingAnchor, bottom: nil, right: nil, padding: .init(top: padding, left: padding, bottom: 0, right: 0), size: .init(width: imageWidth, height: imageWidth))
        plusButton.anchor(top: nil, left: nil, bottom: profileImageView.bottomAnchor, right: profileImageView.trailingAnchor)
        
        addSubview(statsStackView)
        statsStackView.anchor(top: nil, left: profileImageView.trailingAnchor, bottom: nil, right: trailingAnchor, padding: .init(top: 0, left: padding, bottom: 0, right: padding))
        statsStackView.centerYAnchor.constraint(equalTo: profileImageView.centerYAnchor).isActive = true
        
        addSubview(detailStackView)
        detailStackView.anchor(top: profileImageView.bottomAnchor, left: profileImageView.leadingAnchor, bottom: nil, right: statsStackView.trailingAnchor, padding: .init(top: padding, left: 0, bottom: 0, right: 0))
        
        addSubview(editButton)
        editButton.anchor(top: detailStackView.bottomAnchor, left: detailStackView.leadingAnchor, bottom: nil, right: statsStackView.trailingAnchor, padding: .init(top: padding, left: 0, bottom: 0, right: 0), size: .init(width: 0, height: 30))
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    fileprivate func makeLabel(text: String, size: CGFloat, weight: UIFont.Weight = .regular) -> UILabel {
        return UILabel()
            .setFont(ofSize: size, weight: weight)
            .setTextColor(.black)
            .setText(text)
    }
    
    fileprivate func makeStackView(labels: [UILabel]) -> UIStackView {
        return UIStackView(arrangedSubviews: labels)
            .setAxis(.vertical)
            .setSpacing(2)
            .setAlignment(.center)
    }
    
}
