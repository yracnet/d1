import spanishMessages from "ra-language-spanish";
import polyglotI18nProvider from "ra-i18n-polyglot";

// export const i18nProvider = {
//   getLocale: (locale) => spanishMessages,
//   translate: (text) => {
//     console.log(">Z>>", text);
//     return spanishMessages[text];
//   },
// };

export const i18nProvider = polyglotI18nProvider(
  () => spanishMessages,
  "es",
  [{ name: "es", value: "Español" }],
  { allowMissing: true }
);
