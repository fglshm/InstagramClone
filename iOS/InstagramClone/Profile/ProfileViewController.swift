//
//  ProfileViewController.swift
//  InstagramClone
//
//  Created by Shohei Maeno on 2019/06/30.
//  Copyright © 2019 Shohei Maeno. All rights reserved.
//

import UIKit

class ProfileViewController: UIViewController {
    
    fileprivate let myScrollView = UIScrollView()
    fileprivate let menuBar = ProfileMenuBar()
    fileprivate let refreshControl = UIRefreshControl()
    
    fileprivate let imageWidth: CGFloat = UIScreen.main.bounds.width / 4
    fileprivate let padding: CGFloat = 16
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupView()
    }
    
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
    
    lazy var p = UIImageView()
        .setContentMode(.scaleAspectFill)
        .setBorderColor(.lightGray)
        .setBorderWidth(1)
        .setCornerRadius(self.imageWidth / 2)
        .setMasksToBounds(true)
        .setCustomImage(#imageLiteral(resourceName: "person11"))
        
    
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
    
    fileprivate func setupView() {
        view.backgroundColor = #colorLiteral(red: 0.9803921569, green: 0.9803921569, blue: 0.9803921569, alpha: 1)
        
        view.addSubview(myScrollView)
        myScrollView.fillSuperView()
        myScrollView.refreshControl = refreshControl
        refreshControl.addTarget(self, action: #selector(handleRefresh), for: .valueChanged)
        
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
        
        myScrollView.addSubview(profileImageView)
        myScrollView.addSubview(plusButton)
        
        profileImageView.anchor(top: myScrollView.topAnchor, left: view.leadingAnchor, bottom: nil, right: nil, padding: .init(top: padding, left: padding, bottom: 0, right: 0), size: .init(width: imageWidth, height: imageWidth))
        plusButton.anchor(top: nil, left: nil, bottom: profileImageView.bottomAnchor, right: profileImageView.trailingAnchor)
        
        myScrollView.addSubview(statsStackView)
        statsStackView.anchor(top: nil, left: profileImageView.trailingAnchor, bottom: nil, right: view.trailingAnchor, padding: .init(top: 0, left: padding, bottom: 0, right: padding))
        statsStackView.centerYAnchor.constraint(equalTo: profileImageView.centerYAnchor).isActive = true
        
        myScrollView.addSubview(detailStackView)
        detailStackView.anchor(top: profileImageView.bottomAnchor, left: profileImageView.leadingAnchor, bottom: nil, right: statsStackView.trailingAnchor, padding: .init(top: padding, left: 0, bottom: 0, right: 0))
        
        myScrollView.addSubview(editButton)
        editButton.anchor(top: detailStackView.bottomAnchor, left: detailStackView.leadingAnchor, bottom: nil, right: statsStackView.trailingAnchor, padding: .init(top: padding, left: 0, bottom: 0, right: 0), size: .init(width: 0, height: 30))
        
        myScrollView.addSubview(menuBar)
        menuBar.anchor(top: editButton.bottomAnchor, left: view.leadingAnchor, bottom: nil, right: view.trailingAnchor, padding: .init(top: padding, left: 0, bottom: 0, right: 0), size: .init(width: 0, height: 50))
    }
    
    @objc fileprivate func handleRefresh() {
        DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
            self.refreshControl.endRefreshing()
        }
    }
    
}
