import SwiftUI
import shared

@main
struct iOSApp: App {

    let sharedComponent = IosComponent()

    init() {
        IosComponentKt.doInitIosDependencies()
    }

	var body: some Scene {
		WindowGroup {
            ContentView(viewModel: ContentView.ViewModel(getKtorDocsUseCase: sharedComponent.providesGetKtorDocsUseCase()))
		}
	}
}
