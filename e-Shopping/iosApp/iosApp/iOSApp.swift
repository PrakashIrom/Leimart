import SwiftUI

@main
struct iOSApp: App {

    init(){
        DiHelper.initKoin()
    }
    var body: some Scene {
        WindowGroup {
            ComposeView()
        }
    }
}