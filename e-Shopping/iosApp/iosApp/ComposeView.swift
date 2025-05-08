import SwiftUI

fun ComposeView: UIViewControllerRepresentable{
    func makeUIViewController(context: Context) -> UIViewController {
            MainViewController()
        }

        func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
