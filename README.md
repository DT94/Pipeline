# DT94 Pipeline - Backend Application

[![CI/CD DevSecOps](https://github.com/tu-usuario/DT94_Pipeline/actions/workflows/devsecops.yml/badge.svg)](https://github.com/tu-usuario/DT94_Pipeline/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=DT94_Pipeline&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=DT94_Pipeline)
[![Security Scan](https://img.shields.io/badge/Security-Snyk-4c4a73.svg)](https://snyk.io/)

## Descripción del Proyecto

Este repositorio contiene el código fuente y la infraestructura de automatización para una aplicación backend desarrollada en Java. El proyecto está estructurado bajo prácticas modernas de ingeniería de software, priorizando la mantenibilidad, la escalabilidad y, fundamentalmente, la seguridad del código desde las fases iniciales del ciclo de vida del desarrollo (Shift-Left Security).

## Stack Tecnológico y Arquitectura

La aplicación está construida sobre un ecosistema robusto y estandarizado para entornos corporativos:

| Categoría | Tecnología | Propósito |
| :--- | :--- | :--- |
| **Lenguaje** | Java 17 | Core de la aplicación, utilizando características modernas LTS. |
| **Gestor de Paquetes** | Maven | Gestión de dependencias y empaquetado del proyecto. |
| **Framework** | Spring Boot | Estructuración de la lógica de negocio y exposición de APIs (si aplica). |
| **Integración Continua** | GitHub Actions | Orquestación de flujos de trabajo (CI/CD) automatizados en la nube. |
| **Calidad de Código** | SonarCloud | Análisis estático continuo para prevenir bugs y code smells. |
| **Seguridad (SCA)** | Snyk | Escaneo dinámico para bloquear vulnerabilidades en dependencias. |

## Flujo DevSecOps (CI/CD)

El proyecto cuenta con un pipeline automatizado de integración continua que actúa como barrera de calidad para cualquier nuevo cambio introducido en el código. El flujo de trabajo ejecuta secuencialmente las siguientes fases:

1. **Configuración del Entorno:** Aprovisionamiento del runner en Linux y configuración de JDK 17.
2. **Construcción (Build):** Compilación y empaquetado seguro de la aplicación utilizando Maven Wrapper.
3. **Análisis Estático (SAST):** Interacción directa con SonarCloud para evaluar la deuda técnica, cobertura y métricas de calidad del código fuente.
4. **Escaneo de Vulnerabilidades (SCA):** Ejecución de Snyk CLI con un umbral de seguridad estricto (`--severity-threshold=high`). El pipeline aborta automáticamente la ejecución si se detectan dependencias con riesgo de seguridad alto (ej. vulnerabilidades CVE críticas).

## Instrucciones de Ejecución Local

Para levantar este proyecto en un entorno de desarrollo local, asegúrate de tener instalado Java 17.

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/tu-usuario/DT94_Pipeline.git](https://github.com/tu-usuario/DT94_Pipeline.git)
   cd DT94_Pipeline
   2. **Otorgar permisos de ejecución al Wrapper (Linux/Mac):**
   ```bash
   chmod +x mvnw
