//
//  MainPagerViewController.swift
//  InstagramClone
//
//  Created by Shohei Maeno on 2019/06/30.
//  Copyright © 2019 Shohei Maeno. All rights reserved.
//

import UIKit

class MainPageViewController: UIPageViewController {
    
    var cameraViewController: CameraViewController!
    var mainTabbarController: MainTabBarController!
    var messageViewController: MessageViewController!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        dataSource = self
        
        
        cameraViewController = CameraViewController()
        mainTabbarController = MainTabBarController()
        messageViewController = MessageViewController()
        
        setViewControllers([mainTabbarController], direction: .forward, animated: true, completion: nil)
    }
    
}

extension MainPageViewController: UIPageViewControllerDataSource {
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerAfter viewController: UIViewController) -> UIViewController? {
        if (viewController.isKind(of: CameraViewController.self)) {
            return mainTabbarController
        } else if (viewController.isKind(of: MainTabBarController.self)) {
            return messageViewController
        } else {
            return nil
        }
    }
    
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerBefore viewController: UIViewController) -> UIViewController? {
        if (viewController.isKind(of: MessageViewController.self)) {
            return mainTabbarController
        } else if (viewController.isKind(of: MainTabBarController.self)) {
            return cameraViewController
        } else {
            return nil
        }
    }
    
    
}
