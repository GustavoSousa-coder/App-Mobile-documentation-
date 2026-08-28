// Define os plugins utilizados pelo módulo do aplicativo
plugins {
    // Aplica o plugin necessário para criar uma aplicação Android
    alias(libs.plugins.android.application)
}

// Configurações principais do projeto Android
android {

    // Define o namespace utilizado pelas classes geradas pelo Android
    namespace = "br.edu.ifgoiano.quizapp"

    // Define a versão do SDK utilizada para compilar o aplicativo
    compileSdk {

        // Utiliza a versão 36 do Android SDK
        version = release(36) {

            // Define o nível da API secundária utilizado na compilação
            minorApiLevel = 1
        }
    }

    // Ativa recursos adicionais utilizados pelo projeto
    buildFeatures {

        // Ativa o View Binding, permitindo acessar componentes XML
        // através de classes Binding sem utilizar findViewById()
        viewBinding = true
    }

    // Define as configurações padrão do aplicativo
    defaultConfig {

        // Identificador único do aplicativo no Android
        applicationId = "br.edu.ifgoiano.quizapp"

        // Define a versão mínima do Android capaz de executar o aplicativo
        minSdk = 36

        // Define a versão do Android para a qual o aplicativo foi desenvolvido
        targetSdk = 36

        // Código interno utilizado para controlar as versões do aplicativo
        versionCode = 1

        // Nome da versão exibido para o usuário
        versionName = "1.0"

        // Define o executor utilizado nos testes instrumentados do Android
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // Configura os diferentes tipos de compilação do aplicativo
    buildTypes {

        // Configura a versão de produção do aplicativo
        release {

            // Desativa a minificação e ofuscação do código
            isMinifyEnabled = false

            // Define os arquivos com as regras utilizadas pelo ProGuard/R8
            proguardFiles(

                // Utiliza as regras padrão de otimização fornecidas pelo Android
                getDefaultProguardFile("proguard-android-optimize.txt"),

                // Utiliza regras personalizadas definidas pelo projeto
                "proguard-rules.pro"
            )
        }
    }

    // Define a versão do Java utilizada para compilar o projeto
    compileOptions {

        // Define Java 11 como versão utilizada pelo código-fonte
        sourceCompatibility = JavaVersion.VERSION_11

        // Define Java 11 como versão utilizada para gerar o código compilado
        targetCompatibility = JavaVersion.VERSION_11
    }
}

// Dependências essenciais utilizadas pelo projeto
dependencies {

    // Biblioteca AppCompat para compatibilidade de componentes Android
    implementation(libs.androidx.appcompat)

    // Biblioteca ConstraintLayout para criação de layouts flexíveis em XML
    implementation(libs.androidx.constraintlayout)

    // Biblioteca Material Design com componentes de interface do Google
    implementation(libs.material)

    // Biblioteca JUnit utilizada para criação de testes unitários
    testImplementation(libs.junit)

    // Biblioteca Espresso utilizada para testes de interface do Android
    androidTestImplementation(libs.androidx.espresso.core)

    // Biblioteca JUnit integrada ao Android para testes instrumentados
    androidTestImplementation(libs.androidx.junit)
}
