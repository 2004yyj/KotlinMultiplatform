import SwiftUI
import shared
import Combine

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    
    var body: some View {
        Text(viewModel.text).onAppear {
            viewModel.getKtorDocs()
        }
    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        private var disposables = Set<AnyCancellable>()
        private var getKtorDocsUseCase: IosGetKtorDocsUseCase?
        
        
        @Published var text = "Loading..."
        
        init(getKtorDocsUseCase: IosGetKtorDocsUseCase?) {
            self.getKtorDocsUseCase = getKtorDocsUseCase
        }
        
        func getKtorDocs() {
            if (getKtorDocsUseCase != nil) {
                createPublisher(wrapper: getKtorDocsUseCase!.invoke())
                    .subscribe(on: DispatchQueue.main)
                    .sink { (error) in
                        print(error)
                    } receiveValue: {
                        self.text = ($0 as? String) ?? ""
                    }.store(in: &disposables)
            }

//                .sink(
//                    receiveValue: { [weak self] docs in
//                        self?.text = docs.text
//                    }
//                ).store(in: &disposables)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView(viewModel: ContentView.ViewModel(getKtorDocsUseCase: nil))
	}
}
