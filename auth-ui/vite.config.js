import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import { pluginJsonServer } from "vite-plugin-json-server";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    react(),
    pluginJsonServer({
      profile: "mock",
    }),
  ],
});
