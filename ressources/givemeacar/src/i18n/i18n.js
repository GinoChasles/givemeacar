import locales from './lib'

class i18n{

    constructor(locales) {
        this.locales = locales;
    }

    translate(word, locale) {
        if (!this.locales[locale]) {
            throw new Error(`la locale ${locale} n'existe pas`)
        }
            return this.locales[locale][word]

    }

    setLocale(locale) {
        this.locale = locale;
    }
}